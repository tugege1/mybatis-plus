package com.atguigu.test_mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("student")
public class Student {

    @TableId
    /**
     * 主键
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 使用TableField注解标注属性，并指定填充策略
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT)
    private Date updateTime;
    /**
     * 逻辑删除（0 删除,1 未删除、）  全靠TableLogic这个注解，有就是逻辑删除，没有就是物理删除
     */
    @TableLogic(value = "1 ", delval = "0")
    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    private Integer deleteFlag;

}
