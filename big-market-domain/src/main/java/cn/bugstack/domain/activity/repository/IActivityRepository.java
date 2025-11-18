package cn.bugstack.domain.activity.repository;

import cn.bugstack.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.bugstack.domain.activity.model.entity.ActivityCountEntity;
import cn.bugstack.domain.activity.model.entity.ActivityEntity;
import cn.bugstack.domain.activity.model.entity.ActivitySkuEntity;
import cn.bugstack.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;

public interface IActivityRepository {

    // 查询活动商品SKU信息
    ActivitySkuEntity queryActivitySku(Long sku);
    // 查询抽奖活动信息
    ActivityEntity queryRaffleActivityByActivityId(Long activityId);
    // 查询抽奖活动个人次数信息
    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);
    // 保存订单信息
    void doSaveOrder(CreateOrderAggregate createOrderAggregate);
    // 缓存活动商品SKU库存数量
    void cacheActivitySkuStockCount(String cacheKey, Integer stockCount);
    // 扣减活动商品SKU库存数量
    boolean subtractionActivitySkuStock(Long sku, String cacheKey, Date endDateTime);
    // 发送活动商品SKU库存扣减消息到队列
    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);
    // 获取活动商品SKU库存扣减消息队列
    ActivitySkuStockKeyVO takeQueueValue();
    // 清空活动商品SKU库存扣减消息队列
    void clearQueueValue();
    // 清空数据库活动商品SKU库存
    void updateActivitySkuStock(Long sku);
    // 清空数据库活动商品SKU库存
    void clearActivitySkuStock(Long sku);
}
