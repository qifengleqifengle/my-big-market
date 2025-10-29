package cn.bugstack.domain.strategy.service.rule.chain;

public interface ILogicChainArmory {

    // 追加下一个责任人
    ILogicChain appendNext(ILogicChain next);

    // 获取下一个责任人
    ILogicChain next();

}
