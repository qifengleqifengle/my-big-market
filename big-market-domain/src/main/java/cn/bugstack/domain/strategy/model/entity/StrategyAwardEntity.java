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
// 抽奖策略奖品实体
public class StrategyAwardEntity {

    //抽奖策略ID
    private Long strategyId;
    //奖品ID
    private Integer awardId;
    // 抽奖奖品标题
    private String awardTitle;
    // 抽奖奖品副标题
    private String awardSubtitle;
    //库存数量
    private Integer awardCount;
    //剩余库存
    private Integer awardCountSurplus;
    //中奖概率
    private BigDecimal awardRate;
    //排序
    private Integer sort;
}
