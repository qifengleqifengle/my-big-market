package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAwardDao {

    // 查询奖品列表
    List<Award> queryAwardList();

    // 根据奖品ID查询奖品配置
    String queryAwardConfigByAwardId(Integer awardId);

    String queryAwardKeyByAwardId(Integer awardId);
}
