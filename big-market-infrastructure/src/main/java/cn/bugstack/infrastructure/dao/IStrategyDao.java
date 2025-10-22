package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDao {

    // 查询所有的策略列表
    List<Strategy> queryStrategyList();
    // 根据策略ID查询策略信息
    Strategy queryStrategyByStrategyId(Long strategyId);
}
