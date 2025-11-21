package cn.bugstack.domain.activity.service.quota.rule;

public interface IActionChainArmory {

    // 获得下一个处理节点
    IActionChain next();

    // 追加下一个处理节点
    IActionChain appendNext(IActionChain next);
}
