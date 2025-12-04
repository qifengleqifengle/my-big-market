package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.ActivityAccountEntity;
import cn.bugstack.domain.activity.model.entity.DeliveryOrderEntity;
import cn.bugstack.domain.activity.model.entity.SkuRechargeEntity;


public interface IRaffleActivityAccountQuotaService {

    // 创建SKU充值订单
    String createOrder(SkuRechargeEntity skuRechargeEntity);

    // 更新SKU充值订单
    void updateOrder(DeliveryOrderEntity deliveryOrderEntity);

    // 查询用户参与某活动的当天次数
    Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId);

    // 查询用户活动账户信息
    ActivityAccountEntity queryActivityAccountEntity(Long activityId, String userId);

    // 查询用户参与某活动的总次数
    Integer queryRaffleActivityAccountPartakeCount(Long activityId, String userId);
}
