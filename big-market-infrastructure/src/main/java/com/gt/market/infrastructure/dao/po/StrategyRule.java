package com.gt.market.infrastructure.dao.po;

import lombok.Data;

import java.util.Date;

@Data
public class StrategyRule {

    //自增ID
    private Long id;
    //抽奖策略ID
    private Long strategyId;
    //奖品ID
    private Integer awardId;
    //规则类型
    private Integer ruleType;
    //规则模型
    private String ruleModel;
    //规则值
    private String ruleValue;
    //规则描述
    private String ruleDesc;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

}
