package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardEntity {

    //抽奖策略ID
    private Long strategyId;
    //奖品ID
    private Integer awardId;
    //库存数量
    private Integer awardCount;
    //剩余库存
    private Integer awardCountSurplus;
    //中奖概率
    private BigDecimal awardRate;

}
