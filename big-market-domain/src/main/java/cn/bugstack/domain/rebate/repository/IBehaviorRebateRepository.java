package cn.bugstack.domain.rebate.repository;

import cn.bugstack.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import cn.bugstack.domain.rebate.model.valobj.BehaviorTypeVO;
import cn.bugstack.domain.rebate.model.valobj.DailyBehaviorRebateVO;

import java.util.List;

public interface IBehaviorRebateRepository {


    // 查询每日行为返利配置
    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    // 保存用户行为返利记录
    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);
}
