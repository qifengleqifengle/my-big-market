package cn.bugstack.domain.strategy.service.rule.factory;

import cn.bugstack.domain.strategy.model.entity.RuleActionEntity;
import cn.bugstack.domain.strategy.service.annotation.LogicStrategy;
import cn.bugstack.domain.strategy.service.rule.ILogicFilter;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters){
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if(null != strategy){
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter(){
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {
        RULE_BLACKLIST("rule_blacklist", "黑名单规则"),
        RULE_WEIGHT("rule_weight", "权重规则"),
        ;

        private final String code;
        private final String info;
    }

}
