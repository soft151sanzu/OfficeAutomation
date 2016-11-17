package com.zhangly.modules.service;

import com.zhangly.modules.models.Student;

import java.util.List;

/**
 * Created by 青葉 on 2016/11/16.
 */
public interface StudentService {
    public List<Student> queryInfoAll();

    public List<Student> queryInfoAllLimit(int page);

    public List<Student> queryInfoById(String sid) throws Exception;

    public String createInfo(Student student);

    public String updateInfo(Student student);

    public String deleteInfo(String sid);
}
