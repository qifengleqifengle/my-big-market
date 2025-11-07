package cn.bugstack.test.domain;

import cn.bugstack.domain.strategy.model.entity.RaffleAwardEntity;
import cn.bugstack.domain.strategy.model.entity.RaffleFactorEntity;
import cn.bugstack.domain.strategy.service.IRaffleStrategy;
import cn.bugstack.domain.strategy.service.armory.IStrategyArmory;
import cn.bugstack.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import cn.bugstack.domain.strategy.service.rule.filter.impl.RuleLockLogicFilter;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;

    @Resource
    private RuleLockLogicFilter ruleLockLogicFilter;

    @Before
    public void setUp(){
        // 策略装配 100001、100002、100003
        log.info("策略装配结果：{}", strategyArmory.assembleLotteryStrategy(100001L));
        log.info("策略装配结果：{}", strategyArmory.assembleLotteryStrategy(100002L));
        log.info("策略装配结果：{}", strategyArmory.assembleLotteryStrategy(100003L));
        log.info("策略装配结果：{}", strategyArmory.assembleLotteryStrategy(100004L));
        log.info("策略装配结果：{}", strategyArmory.assembleLotteryStrategy(100005L));
        log.info("策略装配结果：{}", strategyArmory.assembleLotteryStrategy(100006L));
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4500L);
        ReflectionTestUtils.setField(ruleLockLogicFilter, "userRaffleCount", 10L);
    }

    @Test
    public void test_performRaffle() throws InterruptedException {

        for (int i=0; i<3; i++) {
            RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                    .userId("xiaofuge")
                    .strategyId(100006L)
                    .build();

            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

            log.info("请求参数:{}", JSON.toJSONString(raffleFactorEntity));
            log.info("抽奖结果:{}", JSON.toJSONString(raffleAwardEntity));
        }
        // new CountDownLatch(1).await();

    }

    @Test
    public void test_performRaffle_blacklist(){
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user003")
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数:{}", JSON.toJSONString(raffleFactorEntity));
        log.info("抽奖结果:{}", JSON.toJSONString(raffleAwardEntity));
    }

    @Test
    public void test_raffle_center_rule_lock(){
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("xiaofuge")
                .strategyId(100003L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数:{}", JSON.toJSONString(raffleFactorEntity));
        log.info("抽奖结果:{}", JSON.toJSONString(raffleAwardEntity));
    }



}
