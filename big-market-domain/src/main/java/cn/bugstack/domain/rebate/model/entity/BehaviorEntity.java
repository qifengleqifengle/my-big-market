package cn.bugstack.domain.rebate.model.entity;

import cn.bugstack.domain.rebate.model.valobj.BehaviorTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorEntity {

    // 用户ID
    private String userId;
    // 行为类型
    private BehaviorTypeVO behaviorTypeVO;
    //
    private String outBusinessNo;

}
