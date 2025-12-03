package cn.bugstack.trigger.api;

import cn.bugstack.trigger.api.dto.ActivityDrawRequestDTO;
import cn.bugstack.trigger.api.dto.ActivityDrawResponseDTO;
import cn.bugstack.trigger.api.dto.UserActivityAccountRequestDTO;
import cn.bugstack.trigger.api.dto.UserActivityAccountResponseDTO;
import cn.bugstack.types.model.Response;

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
}
