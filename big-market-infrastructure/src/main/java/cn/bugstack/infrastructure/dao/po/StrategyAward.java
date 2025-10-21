package cn.bugstack.infrastructure.dao.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StrategyAward {

    //自增ID
    private Long id;
    //抽奖策略ID
    private Long strategyId;
    //奖品ID
    private Integer awardId;
    //奖品标题
    private String awardTitle;
    //奖品副标题
    private String awardSubtitle;
    //库存数量
    private Integer awardCount;
    //剩余库存
    private Integer awardCountSurplus;
    //中奖概率
    private BigDecimal awardRate;
    //规则模型
    private String ruleModels;
    //排序
    private Integer sort;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
