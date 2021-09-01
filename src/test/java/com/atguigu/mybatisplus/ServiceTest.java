package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testCount() {
        int count = userService.count();
        System.out.println(count);
    }

    //批量插入
    @Test
    public void testSaveBatch() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("hhh" + i);
            user.setAge(18 + i);
            list.add(user);
        }
        boolean savebatch = userService.saveBatch(list);
        System.out.println(savebatch);
    }

    @Test
    public void testSelByName() {
        List<User> users = userService.selByName("jack");
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("ttt");
        user.setAge(66);
        boolean insert = userService.save(user);
        System.out.println(insert);
    }

}
