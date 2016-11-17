package com.zhangly.modules.dao;

import com.zhangly.modules.models.Student;

import java.util.List;

/**
 * Created by 青葉 on 2016/11/16.
 */
public interface StudentDao {
    public List<Student> queryInfoAll();

    public List<Student> queryInfoAllLimit(int start,int limit);

    public Student queryInfoById(int sid);

    public boolean createInfo(Student student);

    public boolean updateInfo(Student student);

    public boolean deleteInfo(int sid);
}
