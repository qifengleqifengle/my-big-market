package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.DailyBehaviorRebate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDailyBehaviorRebateDao {

    // 查询每日行为返利配置
    List<DailyBehaviorRebate> queryDailyBehaviorRebateByBehaviorType(String behaviorType);
}
