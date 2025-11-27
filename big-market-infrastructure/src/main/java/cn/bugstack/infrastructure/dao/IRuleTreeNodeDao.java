package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRuleTreeNodeDao {

    // 根据规则树ID查询规则树节点列表
    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);
    // 查询规则锁定信息
    List<RuleTreeNode> queryRuleLocks(String[] treeIds);
}
