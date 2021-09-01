package com.atguigu.mybatisplus.mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

//继承baseMapper自定义mapper,能实现大多数方法
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * @param name
     * @return
     */
    public List<User> selByName(String name);

    /*生成通过姓名查询
    List<User> selectIdAndAgeAndNameAndEmailByName(@Param("name") String name);*/

    //快速创建新增
    //insertSelective

    //快速创建查询
    //selectId + ...AndAgeByIdOrderByIdDesc

    //快速创建修改
    //updateNameByIdAndAge

    //生成删除
    //deleteById
}
