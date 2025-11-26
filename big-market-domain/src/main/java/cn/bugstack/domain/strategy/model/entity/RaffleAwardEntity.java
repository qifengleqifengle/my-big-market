package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 奖品实体
public class RaffleAwardEntity {

    // 奖品ID
    private Integer awardId;
    // 奖品标题
    private String awardTitle;
    //  奖品配置信息
    private String awardConfig;
    // 顺序编号
    private Integer sort;
}
