package cn.bugstack.domain.strategy.repository;

import cn.bugstack.domain.strategy.model.entity.StrategyAwardEntity;
import cn.bugstack.domain.strategy.model.entity.StrategyEntity;
import cn.bugstack.domain.strategy.model.entity.StrategyRuleEntity;
import cn.bugstack.domain.strategy.model.valobj.RuleTreeVO;
import cn.bugstack.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface IStrategyRepository {

    // 查询策略奖品列表
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    // 存储策略奖品列表
    void storeStrategyAwardSearchRateTable(String key, BigDecimal rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    // 获取策略奖品列表的范围区间
    int getRateRange(Long strategyId);

    // 获取策略奖品列表的范围区间
    int getRateRange(String key);

    // 获取策略奖品列表的抽奖结果
    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    // 查询策略信息
    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    // 查询策略规则
    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    // 查询策略规则值
    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    // 查询策略规则值
    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    // 查询策略奖品规则模型
    StrategyAwardRuleModelVO queryStrategyAwardRuleModel(Long strategyId, Integer awardId);

    // 查询规则树
    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);
}
