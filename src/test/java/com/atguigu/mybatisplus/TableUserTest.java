package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TableUserTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("eeee");
        user.setAge(18);
        user.setEmail("5555@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testSelect(){
        User user = userMapper.selectById(1);
        System.out.println(user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);

        HashMap<String,Object> map = new HashMap<>();
        map.put("name","ggg");
        map.put("age",18);
        List<User> users2 = userMapper.selectByMap(map);
        users2.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setAge(19);
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

    @Test
    public void testDelete(){
        int delete = userMapper.deleteById("1410412900387942401");
        System.out.println(delete);
    }

    @Test
    public void testSelByName(){
       List<User> user = userMapper.selByName("jack");
       user.forEach(System.out::println);
    }


}
