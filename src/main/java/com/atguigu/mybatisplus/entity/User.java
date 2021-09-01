package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//通用Mapper是根据反射机制来生成Sql语句，表明和列名都对照实体类，当不一致时就找不到，@TableName注解会给通用mapper参考
@TableName(value = "t_user")
public class User {

    //雪花算法，mybatis-plus默认
    //@TableId(type = IdType.ASSIGN_ID)

    //默认是id不用添加,如果不叫id必须添加
    //@TableId

    //如果数据库更改，实体类还叫id,可以给注解添加value和数据库id映射， Auto表示自增(数据库要设置自增策略)
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
