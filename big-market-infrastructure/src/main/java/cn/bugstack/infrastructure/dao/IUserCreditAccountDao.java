package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.UserCreditAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserCreditAccountDao {

    // 更新用户积分账户，增加可用积分和总积分
    int updateAddAmount(UserCreditAccount userCreditAccountReq);

    // 插入用户积分账户
    void insert(UserCreditAccount userCreditAccountReq);
}
