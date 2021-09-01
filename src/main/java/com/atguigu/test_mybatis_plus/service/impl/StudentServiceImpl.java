package com.atguigu.test_mybatis_plus.service.impl;

import com.atguigu.test_mybatis_plus.entity.Student;
import com.atguigu.test_mybatis_plus.mapper.StudentMapper;
import com.atguigu.test_mybatis_plus.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
