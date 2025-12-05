package cn.bugstack.domain.activity.service.quota;

import cn.bugstack.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import cn.bugstack.domain.activity.model.entity.*;
import cn.bugstack.domain.activity.repository.IActivityRepository;
import cn.bugstack.domain.activity.service.IRaffleActivityAccountQuotaService;
import cn.bugstack.domain.activity.service.quota.policy.ITradePolicy;
import cn.bugstack.domain.activity.service.quota.rule.IActionChain;
import cn.bugstack.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;
import cn.bugstack.types.enums.ResponseCode;
import cn.bugstack.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Slf4j
public abstract class AbstractRaffleActivityAccountQuota extends RaffleActivityAccountQuotaSupport implements IRaffleActivityAccountQuotaService {

    public AbstractRaffleActivityAccountQuota(DefaultActivityChainFactory defaultActivityChainFactory, IActivityRepository activityRepository, Map<String, ITradePolicy> tradePolicyGroup) {
        super(defaultActivityChainFactory, activityRepository);
        this.tradePolicyGroup = tradePolicyGroup;
    }

    private final Map<String, ITradePolicy> tradePolicyGroup;

    @Override
    public UnpaidActivityOrderEntity createOrder(SkuRechargeEntity skuRechargeEntity) {
        // 1、参数校验
        String userId = skuRechargeEntity.getUserId();
        Long sku = skuRechargeEntity.getSku();
        String outBusinessNo = skuRechargeEntity.getOutBusinessNo();
        if(null == sku || StringUtils.isBlank(userId) || StringUtils.isBlank(outBusinessNo)){
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 查询是否存在未支付订单
        UnpaidActivityOrderEntity unpaidActivityOrderEntity = activityRepository.queryUnpaidActivityOrder(skuRechargeEntity);
        if(null != unpaidActivityOrderEntity){
            return unpaidActivityOrderEntity;
        }

        // 2、查询基础信息
        // 2.1、查询活动商品SKU信息
        ActivitySkuEntity activitySkuEntity = queryActivitySku(sku);
        // 2.2、查询抽奖活动信息
        ActivityEntity activityEntity = queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        // 2.3、查询抽奖活动个人次数信息
        ActivityCountEntity activityCountEntity = queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());

        // 3、活动动作规则校验
        IActionChain actionChain = defaultActivityChainFactory.openActionChain();
        actionChain.action(activitySkuEntity, activityEntity, activityCountEntity);

        // 4、构建订单聚合对象
        CreateQuotaOrderAggregate createOrderAggregate = buildOrderAggregate(skuRechargeEntity, activitySkuEntity, activityEntity, activityCountEntity);

        // 5、保存订单
        ITradePolicy tradePolicy = tradePolicyGroup.get(skuRechargeEntity.getOrderTradeType().getCode());
        tradePolicy.trade(createOrderAggregate);

        // 6、返回单号
        ActivityOrderEntity activityOrderEntity = createOrderAggregate.getActivityOrderEntity();
        return UnpaidActivityOrderEntity.builder()
                .userId(userId)
                .orderId(activityOrderEntity.getOrderId())
                .outBusinessNo(activityOrderEntity.getOutBusinessNo())
                .payAmount(activityOrderEntity.getPayAmount())
                .build();

    }

    protected abstract CreateQuotaOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity, ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);
}
