package cn.bugstack.domain.activity.repository;

import cn.bugstack.domain.activity.model.aggregate.CreatePartakeOrderAggregate;
import cn.bugstack.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import cn.bugstack.domain.activity.model.entity.*;
import cn.bugstack.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;
import java.util.List;

public interface IActivityRepository {

    // 查询活动商品SKU信息
    ActivitySkuEntity queryActivitySku(Long sku);
    // 查询抽奖活动信息
    ActivityEntity queryRaffleActivityByActivityId(Long activityId);
    // 查询抽奖活动个人次数信息
    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);
    // 保存订单信息
    void doSaveOrder(CreateQuotaOrderAggregate createOrderAggregate);
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
    // 保存参与订单信息
    void saveCreatePartakeOrderAggregate(CreatePartakeOrderAggregate createPartakeOrderAggregate);
    // 查询未使用的抽奖订单
    UserRaffleOrderEntity queryNoUsedRaffleOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity);
    // 查询用户活动账户信息
    ActivityAccountEntity queryActivityAccountByUserId(String userId, Long activityId);
    // 查询用户活动日账户信息
    ActivityAccountMonthEntity queryActivityAccountMonthByUserId(String userId, Long activityId, String month);
    // 查询用户活动日账户信息
    ActivityAccountDayEntity queryActivityAccountDayByUserId(String userId, Long activityId, String day);
    // 查询活动商品SKU列表
    List<ActivitySkuEntity> queryActivitySkuByActivityId(Long activityId);
    // 查询用户参与某活动的当天次数
    Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId);
    // 查询用户活动账户信息
    ActivityAccountEntity queryActivityAccountEntity(Long activityId, String userId);
    // 查询用户参与某活动的总次数
    Integer queryRaffleActivityAccountPartakeCount(Long activityId, String userId);
}
