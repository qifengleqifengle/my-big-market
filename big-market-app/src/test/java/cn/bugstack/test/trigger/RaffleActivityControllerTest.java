package cn.bugstack.test.trigger;

import cn.bugstack.domain.award.model.entity.DistributeAwardEntity;
import cn.bugstack.domain.award.service.IAwardService;
import cn.bugstack.trigger.api.IRaffleActivityService;
import cn.bugstack.trigger.api.dto.*;
import cn.bugstack.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityControllerTest {

    @Resource
    private IRaffleActivityService raffleActivityService;
    @Resource
    private IAwardService awardService;

    @Test
    public void test_armory() {
        Response<Boolean> response = raffleActivityService.armory(100301L);
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_draw() {
        for (int i = 0; i < 1; i++) {
            ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
            request.setActivityId(100301L);
            request.setUserId("xiaofuge");
            Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(request);

            log.info("请求参数：{}", JSON.toJSONString(request));
            log.info("测试结果：{}", JSON.toJSONString(response));
        }
    }

    @Test
    public void test_draw_blacklist() {
            ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
            request.setActivityId(100301L);
            request.setUserId("user003");
            Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(request);

            log.info("请求参数：{}", JSON.toJSONString(request));
            log.info("测试结果：{}", JSON.toJSONString(response));

    }

    @Test
    public void test_distributeAward() {
        DistributeAwardEntity entity = new DistributeAwardEntity();
        entity.setUserId("user003");
        entity.setOrderId("xxx");
        entity.setAwardId(101);  // 黑名单积分奖品
        entity.setAwardConfig("0.01,1");  // 积分范围

        awardService.distributeAward(entity);
    }

    @Test
    public void test_calendarSignRebate() {
        Response<Boolean> response = raffleActivityService.calendarSignRebate("user003");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_isCalendarSignRebate() {
        Response<Boolean> response = raffleActivityService.isCalendarSignRebate("user003");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_queryUserActivityAccount() {
        UserActivityAccountRequestDTO request = new UserActivityAccountRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("xiaofuge");

        // 查询数据
        Response<UserActivityAccountResponseDTO> response = raffleActivityService.queryUserActivityAccount(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_querySkuProductListByActivityId() {
        Long request = 100301L;
        Response<List<SkuProductResponseDTO>> response = raffleActivityService.querySkuProductListByActivityId(request);
        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_queryUserCreditAccount() {
        String request = "xiaofuge";
        Response<BigDecimal> response = raffleActivityService.queryUserCreditAccount(request);
        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_creditPayExchangeSku() throws InterruptedException {
        SkuProductShopCartRequestDTO request = new SkuProductShopCartRequestDTO();
        request.setUserId("xiaofuge");
        request.setSku(9011L);
        Response<Boolean> response = raffleActivityService.creditPayExchangeSku(request);
        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));

        new CountDownLatch(1).await();
    }


}

