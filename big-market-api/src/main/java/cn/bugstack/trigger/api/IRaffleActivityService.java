package cn.bugstack.trigger.api;

import cn.bugstack.trigger.api.dto.ActivityDrawRequestDTO;
import cn.bugstack.trigger.api.dto.ActivityDrawResponseDTO;
import cn.bugstack.types.model.Response;

public interface IRaffleActivityService {

    // 活动装配，数据预热缓存
    Response<Boolean> armory(Long activityId);

    // 活动抽奖接口
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);
}
