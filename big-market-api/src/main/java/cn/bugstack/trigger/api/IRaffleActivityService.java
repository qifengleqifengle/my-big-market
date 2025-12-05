package cn.bugstack.trigger.api;

import cn.bugstack.trigger.api.dto.*;
import cn.bugstack.types.model.Response;

import java.math.BigDecimal;
import java.util.List;

public interface IRaffleActivityService {

    // 活动装配，数据预热缓存
    Response<Boolean> armory(Long activityId);

    // 活动抽奖接口
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);

    // 日历签到返利接口
    Response<Boolean> calendarSignRebate(String userId);

    // 是否已签到返利接口
    Response<Boolean> isCalendarSignRebate(String userId);

    // 查询用户活动账户信息
    Response<UserActivityAccountResponseDTO> queryUserActivityAccount(UserActivityAccountRequestDTO request);

    // 查询活动关联的SKU商品列表
    Response<List<SkuProductResponseDTO>> querySkuProductListByActivityId(Long activityId);

    // 查询积分账户余额
    Response<BigDecimal> queryUserCreditAccount(String userId);

    // 积分支付兑换SKU
    Response<Boolean> creditPayExchangeSku(SkuProductShopCartRequestDTO request);
}
