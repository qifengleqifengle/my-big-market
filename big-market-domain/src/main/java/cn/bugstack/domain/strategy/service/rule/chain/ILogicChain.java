package cn.bugstack.domain.strategy.service.rule.chain;

public interface ILogicChain extends ILogicChainArmory{

    // 规则链路处理 责任链接口
    Integer logic(String userId, Long strategyId);

}
