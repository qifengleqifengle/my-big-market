package cn.bugstack.domain.strategy.service.rule.chain;

import cn.bugstack.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

public interface ILogicChain extends ILogicChainArmory{

    // 规则链路处理 责任链接口
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);

}
