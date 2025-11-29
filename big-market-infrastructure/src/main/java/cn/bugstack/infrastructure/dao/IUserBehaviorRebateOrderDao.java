package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.UserBehaviorRebateOrder;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserBehaviorRebateOrderDao {
    // 插入用户行为返利订单
    void insert(UserBehaviorRebateOrder userBehaviorRebateOrder);

}
