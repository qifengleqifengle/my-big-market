package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyAwardDao {

    // 查询策略奖品列表
    List<StrategyAward> queryStrategyAwardList();
    // 根据策略ID查询策略奖品列表
    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);
    // 根据策略奖品信息查询策略奖品规则模型
    String queryStrategyAwardRuleModels(StrategyAward strategyAward);
    // 更新策略奖品库存
    void updateStrategyAwardStock(StrategyAward strategyAward);
}
