package cn.bugstack.domain.strategy.service.armory;

public interface IStrategyArmory {

    boolean assembleLotteryStrategyByActivityId(Long activityId);

    boolean assembleLotteryStrategy(Long strategyId);
}
