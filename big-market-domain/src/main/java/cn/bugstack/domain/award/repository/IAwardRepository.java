package cn.bugstack.domain.award.repository;

import cn.bugstack.domain.award.model.aggregate.UserAwardRecordAggregate;

public interface IAwardRepository {

    // 保存用户奖品领取记录及发奖任务
    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);
}
