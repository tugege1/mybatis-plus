package com.atguigu.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自定义一个类，实现 MetaObjectHandler 接口，并重写方法。
 * 　添加 @Component 注解，交给 Spring 去管理。
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * strictInsertFill参数列表为 :MetaObject对象  实体类属性名  类型  值
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "deleteFlag", Integer.class, 1);
    }

    /**
     * 最后一次更新时间  setFieldValByName参数是：实体类属性名  类型  MetaObject对象
     * 类型要和实体类一致   date日期 不是 data!!!!
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", Date.class, metaObject);
    }
}
