package cn.bugstack.test.trigger;

import cn.bugstack.trigger.api.IRaffleActivityService;
import cn.bugstack.trigger.api.dto.ActivityDrawRequestDTO;
import cn.bugstack.trigger.api.dto.ActivityDrawResponseDTO;
import cn.bugstack.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityControllerTest {

    @Resource
    private IRaffleActivityService raffleActivityService;

    @Test
    public void test_armory(){
        Response<Boolean> response = raffleActivityService.armory(100301L);
        log.info("返回结果：{}", response);
    }

    @Test
    public void test_draw(){
        ActivityDrawRequestDTO requestDTO = new ActivityDrawRequestDTO();
        requestDTO.setUserId("xiaofuge");
        requestDTO.setActivityId(100301L);
        Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(requestDTO);

        log.info("请求参数：{}", JSON.toJSONString(requestDTO));
        log.info("返回结果：{}", JSON.toJSONString(response));
    }
}
