package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.SkuRechargeEntity;


public interface IRaffleOrder {

    // 创建SKU充值订单
    String createSkuRechargeOrder(SkuRechargeEntity skuRechargeEntity);
}
