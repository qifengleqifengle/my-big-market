package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.UserAwardRecord;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserAwardRecordDao {
    // 插入用户奖品发放记录
    void insert(UserAwardRecord userAwardRecord);

    // 更新用户奖品发放记录状态为已完成
    int updateAwardRecordCompletedState(UserAwardRecord userAwardRecordReq);
}
