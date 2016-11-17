package com.zhangly.modules.service.impl;

import com.zhangly.modules.dao.StudentDao;
import com.zhangly.modules.models.Student;
import com.zhangly.modules.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 青葉 on 2016/11/16.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public List<Student> queryInfoAll() {
        return studentDao.queryInfoAll();
    }

    @Override
    public List<Student> queryInfoAllLimit(int page) {
        //new一个空的数据堆栈
        List<Student> studentList = new ArrayList<Student>();
        //提供start和limit的初始值
        int start = 1;
        //配置每页的信息条数
        int limit = 5;
        //因为当页码为1时就是默认的start和limit，无需赋值所以判断
        if (page != 1) {
            //根据页面赋给页面起始条数和结束条数
            start = (page - 1) * limit + 1;
        }
        //调用service层方法获得该页面的数据集合
        List<Student> students = studentDao.queryInfoAllLimit(start, limit);
        for (Student student : students) System.out.println(student);
        //将获取到的数据存入先前new好的数据堆栈
        studentList.addAll(students);
        //返回给控制器
        return studentList;
    }

    @Override
    public List<Student> queryInfoById(String sid) throws Exception {
        //new一个空的数据堆栈
        List<Student> studentList = new ArrayList<Student>();
        //使用系统断言和正则表达式判断前台传来的sid是否为纯数字
        Assert.isTrue(sid.matches("\\d+"),"not number");
        //调用Service层的queryInfoById方法查询对应的数据
        Student student = studentDao.queryInfoById(Integer.valueOf(sid));
        //存入数据堆栈
        studentList.add(student);
        //返回给控制器
        return studentList;
    }

    @Override
    public String createInfo(Student student) {
        //声明一个boolean，默认为false
        boolean flag = false;
        try{
            //当该方法成功时会返回true，并赋值给flag
            flag = studentDao.createInfo(student);
        }catch (Exception e){
            return "error";
        }
        //根据flag判断输出的逻辑名
        if (flag) {
            return "success";
        } else {
            return "error";
        }
    }

    @Override
    public String updateInfo(Student student) {
        //声明一个boolean，默认为false
        boolean flag = false;
        try{
            //当该方法成功时会返回true，并赋值给flag
            flag = studentDao.updateInfo(student);
        }catch (Exception e){
            return "error";
        }
        //根据flag判断输出的逻辑名
        if (flag) {
            return "success";
        } else {
            return "error";
        }
    }

    @Override
    public String deleteInfo(String sid) {
        //验证前台传来的sid是否为空
        if (sid != null) {
            //声明一个boolean，默认为false
            boolean flag = false;
            try{
                //当该方法成功时会返回true，并赋值给flag
                flag = studentDao.deleteInfo(Integer.valueOf(sid));
            }catch (Exception e){
                return "error";
            }
            //根据flag判断输出的逻辑名
            if (flag) {
                return "success";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
}
