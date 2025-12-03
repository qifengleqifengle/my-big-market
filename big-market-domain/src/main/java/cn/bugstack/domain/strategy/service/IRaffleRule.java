package cn.bugstack.domain.strategy.service;

import cn.bugstack.domain.strategy.model.valobj.RuleWeightVO;

import java.util.List;
import java.util.Map;

public interface IRaffleRule {

    // 查询奖品规则锁定数量
    Map<String, Integer> queryAwardRuleLockCount(String[] treeIds);
    // 查询奖品规则权重配置
    List<RuleWeightVO> queryAwardRuleWeight(Long strategyId);
    // 查询活动对应的奖品规则权重配置
    List<RuleWeightVO> queryAwardRuleWeightByActivityId(Long activityId);
}
