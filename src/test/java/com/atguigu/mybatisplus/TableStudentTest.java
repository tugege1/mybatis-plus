package com.atguigu.mybatisplus;

import com.atguigu.test_mybatis_plus.entity.Student;
import com.atguigu.test_mybatis_plus.mapper.StudentMapper;
import com.atguigu.test_mybatis_plus.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TableStudentTest {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private StudentService studentService;

    @Test
    public void studentTest() {
        List<Student> stu = studentMapper.selectList(null);
        stu.forEach(System.out::println);
    }

    @Test
    public void addStudentTest() {
        Student student = new Student();
        student.setAge(18);
        student.setName("张三");
        student.setEmail("121213@qq.com");
        //未使用自动填充时，需要自家手动添加，并且都要添加
        /*student.setCreateTime(new Date());
        student.setUpdateTime(new Date());*/
        if (studentMapper.insert(student) > 0) {
            studentMapper.selectList(null).forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }

    @Test
    public void addStuAutoTest() {
        Student student = new Student();
        student.setAge(19);
        student.setName("李四");
        student.setEmail("65452@qq.com");
        if (studentService.save(student)) {
            studentService.list().forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }

    @Test
    public void removeStuTest() {
        if (studentService.removeById("1422084749735780353")) {
            System.out.println("删除成功");
            studentService.list().forEach(System.out::println);
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 分页测试
     */
    @Test
    public void pageTest() {
        Page<Student> page = new Page<>(0, 2);
        studentService.page(page, null);
        System.out.println(page.getCurrent()); // 获取当前页
        System.out.println(page.getTotal()); // 获取总记录数
        System.out.println(page.getSize()); // 获取每页的条数
        System.out.println(page.getRecords()); // 获取每页数据的集合
        System.out.println(page.getPages()); // 获取总页数
        System.out.println(page.hasNext()); // 是否存在下一页
        System.out.println(page.hasPrevious()); // 是否存在上一页
    }

    /**
     * QueryMapper测试
     * eq:等于  ne:不等于   gt:大于 ge:大于等于  lt:小于 le:小于等于   like:两边% likeleft:左 likeright:右
     */
    @Test
    public void queryMapperTest() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        String id = "3";
        int age = 18;
        String name = "J";
        int[] ids = {1,3,5};
        //queryWrapper.eq(id!=null,"id",id);
        //queryWrapper.ne(id!=null,"id",id);

        //queryWrapper.gt(age!=0,"age",age);
        queryWrapper.ge(age!=0,"age",age);
        //queryWrapper.lt(age!=0,"age",age);
        //queryWrapper.le(age!=0,"age",age);

        //queryWrapper.like(id!=null,"name",name);
        //queryWrapper.likeLeft(id!=null,"name",name);
        //queryWrapper.likeRight(id!=null,"name",name);

        queryWrapper.in(ids.length!=0,"id",1,2,5);

        List<Student> stu = studentMapper.selectList(queryWrapper);
        stu.forEach(System.out::println);
    }

    /**
     * Date日期格式
     *
     */
    @Test
    public void dateToStringTest() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        //format是日期转字符串
        String str = simpleDateFormat.format(date);
        System.out.println(str);

        //parse是字符串转日期  要上抛一个 转换异常
        Date d = simpleDateFormat.parse(str);
        System.out.println(d);
    }
}
