package com.example;

import com.example.pojo.Category;
import com.example.utils.ThreadLocalUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class BigEventApplicationTests {

    @Test
    public void testThreadLocalSetAndGet() {
        // 提供ThreadLocal对象
        ThreadLocal t1 = new ThreadLocal();

        // 开启两个线程
        new Thread(() -> {
            t1.set("gh");
        }, "蓝色").start();

        new Thread(() -> {
            t1.set("gh2");
        }, "蓝色").start();
    }

    @Test
    public void add(Category category) {
        // 补充属性值
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        System.out.println("--------------------" + userId);

    }

    // 生成UUID
    @Test
    public void testUUID() {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }

}
