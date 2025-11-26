package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.UserRaffleOrder;
import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserRaffleOrderDao {
    // 查询未使用抽奖订单
    @DBRouter
    UserRaffleOrder queryNoUsedRaffleOrder(UserRaffleOrder userRaffleOrderReq);

    // 新增抽奖订单
    void insert(UserRaffleOrder build);

    // 更新抽奖订单状态为已使用
    int updateUserRaffleOrderStateUsed(UserRaffleOrder userRaffleOrderReq);
}
