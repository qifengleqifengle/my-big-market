package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 抽奖因子实体
public class RaffleFactorEntity {

    // 用户ID
    private String userId;
    // 策略ID
    private Long strategyId;

}
