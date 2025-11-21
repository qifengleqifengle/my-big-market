package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.valobj.ActivitySkuStockKeyVO;

public interface IRaffleActivitySkuStockService {

    // 获取商品库存消耗队列
    ActivitySkuStockKeyVO takeQueueValue() throws InterruptedException;

    // 清空队列
    void clearQueueValue();

    // 延迟队列 + 任务趋势更新活动sku库存
    void updateActivitySkuStock(Long sku);

    // 缓存库存已消耗完毕，清空数据库库存
    void clearActivitySkuStock(Long sku);
}
