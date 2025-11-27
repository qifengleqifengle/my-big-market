package cn.bugstack.trigger.api.dto;

import lombok.Data;

@Data
public class RaffleAwardListRequestDTO {

    // 抽奖策略Id
    @Deprecated
    private Long strategyId;
    // 活动Id
    private Long activityId;
    // 用户Id
    private String userId;
}
