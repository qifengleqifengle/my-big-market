package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.SkuRechargeEntity;


public interface IRaffleActivityAccountQuotaService {

    // 创建SKU充值订单
    String createOrder(SkuRechargeEntity skuRechargeEntity);

    // 查询用户参与某活动的当天次数
    Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId);
}
