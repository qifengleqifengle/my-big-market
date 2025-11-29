package cn.bugstack.test.rebate;

import cn.bugstack.domain.rebate.model.entity.BehaviorEntity;
import cn.bugstack.domain.rebate.model.valobj.BehaviorTypeVO;
import cn.bugstack.domain.rebate.service.IBehaviorRebateService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BehaviorRebateServiceTest {

    @Resource
    private IBehaviorRebateService behaviorRebateService;

    @Test
    public void test_createOrder(){
        BehaviorEntity behaviorEntity = new BehaviorEntity();
        behaviorEntity.setUserId("xiaofuge");
        behaviorEntity.setBehaviorTypeVO(BehaviorTypeVO.SIGN);
        // 幂等参数
        behaviorEntity.setOutBusinessNo("202511293");

        List<String> orderIds = behaviorRebateService.createOrder(behaviorEntity);
        log.info("请求参数：{}", JSON.toJSONString(behaviorEntity));
        log.info("返回结果：{}", JSON.toJSONString(orderIds));
    }
}
