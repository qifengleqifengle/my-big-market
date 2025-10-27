package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 规则动作实体
public class RuleActionEntity <T extends RuleActionEntity.RaffleEntity> {

    // 规则动作编码
    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    // 规则动作信息
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    // 规则动作模型
    private String ruleModel;
    // 规则动作数据
    private T data;

    static public class RaffleEntity{


    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    // 抽奖前置动作实体
    static public class RaffleBeforeEntity extends RaffleEntity{

        // 策略ID
        private Long strategyId;

        // 权重值key; 用于抽奖时可以选择权重抽奖
        private String ruleWeightValueKey;

        // 奖品ID
        private Integer awardId;
    }

    // 抽奖中动作实体
    static public class RaffleCenterEntity extends RaffleEntity{

    }

    // 抽奖后动作实体
    static public class RaffleAfterEntity extends RaffleEntity{

    }

}
