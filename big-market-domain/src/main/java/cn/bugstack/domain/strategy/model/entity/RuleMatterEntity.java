package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 抽奖规则物料实体
public class RuleMatterEntity {

    // 用户ID
    private String userId;
    // 策略ID
    private Long strategyId;
    // 抽奖奖品ID
    private Integer awardId;
    // 规则模型
    private String ruleModel;

}
