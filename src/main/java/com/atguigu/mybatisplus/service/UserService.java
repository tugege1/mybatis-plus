package com.atguigu.mybatisplus.service;

import com.atguigu.mybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends IService<User> {

    public List<User> selByName(String name);
}
