package cn.bugstack.domain.activity.repository;

import cn.bugstack.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.bugstack.domain.activity.model.entity.ActivityCountEntity;
import cn.bugstack.domain.activity.model.entity.ActivityEntity;
import cn.bugstack.domain.activity.model.entity.ActivitySkuEntity;

public interface IActivityRepository {

    // 查询活动商品SKU信息
    ActivitySkuEntity queryActivitySku(Long sku);
    // 查询抽奖活动信息
    ActivityEntity queryRaffleActivityByActivityId(Long activityId);
    // 查询抽奖活动个人次数信息
    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);
    // 保存订单信息
    void doSaveOrder(CreateOrderAggregate createOrderAggregate);
}
