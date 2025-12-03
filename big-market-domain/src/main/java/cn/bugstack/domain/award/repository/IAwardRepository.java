package cn.bugstack.domain.award.repository;

import cn.bugstack.domain.award.model.aggregate.GiveOutPrizeAggregate;
import cn.bugstack.domain.award.model.aggregate.UserAwardRecordAggregate;

public interface IAwardRepository {

    // 保存用户奖品领取记录及发奖任务
    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);
    // 查询奖品配置
    String queryAwardConfig(Integer awardId);
    // 保存发奖聚合根对象
    void saveGiveOutPrizeAggregate(GiveOutPrizeAggregate giveOutPrizeAggregate);
    // 查询奖品key
    String queryAwardKey(Integer awardId);
}
