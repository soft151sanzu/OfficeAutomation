package com.zhangly.test;

import com.zhangly.modules.dao.StudentDao;
import com.zhangly.modules.dao.impl.StudentDaoImpl;
import com.zhangly.modules.models.Student;
import org.junit.Test;

/**
 * Created by 青葉 on 2016/11/16.
 */
public class StudentTest {
    private static StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void queryAllTest() {
        for (Student student : studentDao.queryInfoAll()) {
            System.out.println(student);
        }
    }

    @Test
    public void queryByIdTest(){
        System.out.println(studentDao.queryInfoById(1));
    }

    @Test
    public void addInfo(){
        Student student = new Student();
        for (int i = 0; i < 10; i++) {
            student.setSid(i);
            student.setSname("zhangsan");
            student.setAge(18);
            System.out.println(studentDao.createInfo(student));
        }
    }

    @Test
    public void editInfo(){
        Student student = new Student();
        student.setSid(1);
        student.setSname("zhangsanupdate");
        student.setAge(20);
        System.out.println(studentDao.updateInfo(student));
    }

    @Test
    public void removeInfo(){
        System.out.println(studentDao.deleteInfo(1));
    }

    @Test
    public void tests(){
        String str = "f5";
        boolean flag = str.matches("\\d+");
        System.out.println(flag);
    }
}
