package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 抽奖策略实体
public class StrategyEntity {

    //抽奖策略ID
    private Long strategyId;
    //抽奖策略描述
    private String strategyDesc;
    //策略方式
    private String ruleModels;

    public String[] ruleModels(){
        if(StringUtils.isBlank(ruleModels)){
            return null;
        }

        return ruleModels.split(Constants.SPLIT);
    }

    public String getRuleWeight(){
        String[] ruleModels = this.ruleModels();
        for (String ruleModel : ruleModels) {
            if("rule_weight".equals(ruleModel)){
                return ruleModel;
            }
        }

        return null;
    }

}
