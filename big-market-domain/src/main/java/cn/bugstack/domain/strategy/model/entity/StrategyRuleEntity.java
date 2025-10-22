package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRuleEntity {

    //抽奖策略ID
    private Long strategyId;
    //奖品ID
    private Integer awardId;
    //规则类型
    private Integer ruleType;
    //规则模型
    private String ruleModel;
    //规则值
    private String ruleValue;
    //规则描述
    private String ruleDesc;

    public Map<String, List<Integer>> getRuleValueMap() {
        if(!"rule_weight".equals(ruleModel)){
            return null;
        }
        String[] ruleValueGroups = ruleValue.split(Constants.SPACE);
        Map<String, List<Integer>> ruleMap = new HashMap<>();
        for(String ruleValueGroup : ruleValueGroups){
            // 检查输入是否为空
            if(ruleValueGroup == null || ruleValueGroup.isEmpty()){
                return ruleMap;
            }
            // 分割字符串以获取键和值
            String[] parts = ruleValueGroup.split(Constants.COLON);
            if(parts.length != 2){
                throw new IllegalArgumentException("rule_weight rule_rule invalid input format" + ruleValueGroup);
            }
            // 解析值
            String[] valueStrings = parts[1].split(Constants.SPLIT);
            List<Integer> values = new ArrayList<>();
            for(String valueString : valueStrings){
                values.add(Integer.parseInt(valueString));
            }
            // 将键和值添加到映射中
            ruleMap.put(ruleValueGroup, values);
        }
        return ruleMap;
    }

}
