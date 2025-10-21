package cn.bugstack.test.infrastructure;

import com.alibaba.fastjson.JSON;
import cn.bugstack.infrastructure.dao.IAwardDao;
import cn.bugstack.infrastructure.dao.po.Award;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

// 奖品DAO测试类
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {

    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_queryAwardList() {
        List<Award> awardList = awardDao.queryAwardList();
        log.info("奖品列表：{}", JSON.toJSONString(awardList));
    }


}
