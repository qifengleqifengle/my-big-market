package cn.bugstack.domain.strategy.service.rule.chain.factory;

import cn.bugstack.domain.strategy.model.entity.StrategyEntity;
import cn.bugstack.domain.strategy.repository.IStrategyRepository;
import cn.bugstack.domain.strategy.service.rule.chain.ILogicChain;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultChainFactory {

    private final Map<String, ILogicChain> logicChainGroup;

    private final IStrategyRepository repository;

    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup, IStrategyRepository repository) {
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }

    public ILogicChain openLogicChain(Long strategyId) {
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);

        String[] ruleModels = strategy.ruleModels();

        if(null == ruleModels || 0 == ruleModels.length){
            return logicChainGroup.get(LogicModel.RULE_DEFAULT.getCode());
        }

        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        for(int i = 1; i< ruleModels.length; i++){
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current = current.appendNext(nextChain);
        }

        current.appendNext(logicChainGroup.get(LogicModel.RULE_DEFAULT.getCode()));

        return logicChain;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        // 奖品ID
        private Integer awardId;
        // 逻辑模型
        private String logicModel;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_BLACKLIST("rule_blacklist", "黑名单规则"),
        RULE_WEIGHT("rule_weight", "权重规则"),
        RULE_DEFAULT("default", "默认规则"),
        ;

        private final String code;
        private final String info;
    }

}
