package com.zhangly.modules.controller;

import com.zhangly.modules.models.Student;
import com.zhangly.modules.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 青葉 on 2016/11/16.
 */

/**
 * 使用@Controller注解注册为控制器组件，自动扫描的时候会扫描入IOC容器，bean名称与类名相同
 */
@Controller
public class StudentController {
    /**
     * 自动注入@Resource注解方式将IOC容器Spring-servlet.xml中的对应名称属性注入进来
     */
    @Resource
    private StudentService studentService;

    /**
     * 获取数据库中全部数据
     * @return 返回逻辑名
     */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String queryInfoAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<Student> studentList = studentService.queryInfoAll();
        session.setAttribute("studentList", studentList);
        return "info";
    }

    /**
     * 分页功能实现
     * @param page 接收前台的page页码
     * @return 返回逻辑名
     */
    @RequestMapping(value = "/studentlimit", method = RequestMethod.GET)
    public String queryInfoAllLimit(String page, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<Student> studentList = new ArrayList<Student>();
        //获取最大信息条数
        int count = studentService.queryInfoAll().size();
        //得到最大页码
        int maxPage = count/5;
        if (page.matches("\\d+")){
            //因为传过来的页码是String，在这里转成int类型
            int pages = Integer.valueOf(page);
            //如果前台传来的页码为0则强制转为1避免报错
            if (pages == 0){
                pages = 1;
                page = "1";
            }
            //判断前台给出页码是否大于最大页码，是则使前台页码等于最大页码
            if (pages > maxPage){
                pages = maxPage;
            }
            studentList = studentService.queryInfoAllLimit(pages);
        }
        //将数据堆栈和页码存入session
        session.setAttribute("studentList", studentList);
        session.setAttribute("page", page);
        session.setAttribute("maxPage",maxPage);
        //返回逻辑名
        return "info";
    }

    @RequestMapping(value = "/studentbyid", method = RequestMethod.GET)
    public String queryInfoById(String sid, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<Student> studentList = new ArrayList<Student>();
        try {
            List<Student> students = studentService.queryInfoById(sid);
            studentList.addAll(students);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        //将数据堆栈存入session
        session.setAttribute("studentList", studentList);
        //返回逻辑名
        return "info";
    }

    @RequestMapping(value = "/studentcreate", method = RequestMethod.POST)
    public String createInfo(Student student) {
        return studentService.createInfo(student);
    }

    @RequestMapping(value = "/studentupdate", method = RequestMethod.POST)
    public String updateInfo(Student student) {
        return studentService.updateInfo(student);
    }

    @RequestMapping(value = "/studentdelete", method = RequestMethod.GET)
    public String delete(String sid, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return studentService.deleteInfo(sid);
    }
}
