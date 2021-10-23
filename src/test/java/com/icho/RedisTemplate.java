package com.icho;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: icho
 * @Date: 2021/9/18 18:09
 * @Describe:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplate {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("icho", "18");

        System.out.println("value = " + redisTemplate.opsForValue().get("icho"));
    }

    @Test
    public void setTimeDemo() {
        redisTemplate.opsForValue().set("icho", "18", 10, TimeUnit.SECONDS);
    }

    @Test
    public void hashDemo() {
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps("user");

        hashOps.put("name","icho");
        hashOps.put("age", "18");

        Object name = hashOps.get("name");
        System.out.println("name = " + name);

        Map<Object, Object> map = hashOps.entries();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /*@Test
    public void MDemo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","icho");
        map.put("age","18");
        map.put("sex","1");
        redisTemplate.opsForValue().multiSet(map);
    }*/
}
