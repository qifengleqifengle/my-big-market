package cn.bugstack.domain.strategy.service.armory;

import java.util.Date;

public interface IStrategyDispatch {

    /**
     * 获取随机奖品ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer getRandomAwardId(Long strategyId);

    /**
     * 根据规则值获取随机奖品ID
     * @param strategyId 策略ID
     * @param ruleValue 规则值
     * @return 奖品ID
     */
    Integer getRandomAwardId(Long strategyId, String ruleValue);

    /**
     * 根据规则值获取随机奖品ID
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @return  是否扣减成功
     */
    Boolean subtractionAwardStock(Long strategyId, Integer awardId, Date endDateTime);

}
