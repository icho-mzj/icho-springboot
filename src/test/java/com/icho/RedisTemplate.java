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

import java.util.*;
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

    public static void main(String[] args) {
        List<String> list = Arrays.asList("01","02","03","04","05");
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        map1.put("date", "01");
        map1.put("val", "aa");

        map2.put("date", "02");
        map2.put("val", "bb");

        map3.put("date", "03");
        map3.put("val", "cc");
        List<HashMap<String, String>> list1 = Arrays.asList(map1,map2,map3);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list1.get(i).get("date"))){
                result.add(i,list1.get(i).get("val"));
            }else {
                result.add(i, "-");
            }
        }
        Collections.reverse(result);
        System.out.println("result = " + result);
    }

    /*@Test
    public void MDemo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","icho");
        map.put("age","18");
        map.put("sex","1");
        redisTemplate.opsForValue().multiSet(map);
    }*/

    // TODO 常用的redisAPI
}
