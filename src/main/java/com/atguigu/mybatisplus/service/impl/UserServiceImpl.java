package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
//继承ServiceImpl(自带大部分实现的方法),泛型是mapper(dao)，以及mapper管理的实体类    实现UserService，方便自己扩展
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    /* @Resource
    private UserMapper userMapper;*/

    //由于service源码中泛型包括BaseMapper，所以不需要注入mapper,直接BaseMapper.方法即可
    @Override
    public List<User> selByName(String name) {
        List<User> user = baseMapper.selByName(name);
        return user;
    }
}
