package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyRuleDao {

    // 查询所有规则
    List<StrategyRule> queryStrategyRuleList();
    // 根据条件查询规则
    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);
    // 根据规则获取值
    String queryStrategyRuleValue(StrategyRule strategyRule);
}
