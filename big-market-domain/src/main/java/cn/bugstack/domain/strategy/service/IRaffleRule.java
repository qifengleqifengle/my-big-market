package cn.bugstack.domain.strategy.service;

import java.util.Map;

public interface IRaffleRule {

    // 查询奖品规则锁定数量
    Map<String, Integer> queryAwardRuleLockCount(String[] treeIds);

}
