package cn.bugstack.domain.activity.model.aggregate;

import cn.bugstack.domain.activity.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartakeOrderAggregate {

    private String userId;

    private Long activityId;

    private ActivityAccountEntity activityAccountEntity;

    private boolean isExistAccountMonth = true;

    private ActivityAccountMonthEntity activityAccountMonthEntity;

    private boolean isExistAccountDay = true;

    private ActivityAccountDayEntity activityAccountDayEntity;

    private UserRaffleOrderEntity userRaffleOrderEntity;
}
