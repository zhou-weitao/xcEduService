package com.xuecheng.manage.cms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author wtzhou
 * @date 2020/6/4 4:32 下午
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestOKHttpTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test1() {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/page/config/getModel/5a791725dd573c3574ee333f", Map.class);
        System.out.println(forEntity.toString());
    }
}
