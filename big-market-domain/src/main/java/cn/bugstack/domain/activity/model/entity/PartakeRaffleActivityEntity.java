package cn.bugstack.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartakeRaffleActivityEntity {

    // 用户Id
    private String userId;

    // 活动Id
    private Long activityId;
}
