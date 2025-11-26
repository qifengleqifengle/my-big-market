package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRaffleActivityDao {

    // 根据活动ID查询活动信息
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

    // 根据活动ID查询抽奖策略ID
    Long queryStrategyIdByActivityId(Long activityId);

    // 根据策略ID查询活动ID
    Long queryActivityIdByStrategyId(Long strategyId);
}
