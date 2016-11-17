package com.zhangly.modules.dao.impl;

import com.zhangly.modules.dao.StudentDao;
import com.zhangly.modules.models.Student;
import com.zhangly.util.AutowireDaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 青葉 on 2016/11/16.
 */
@Repository
public class StudentDaoImpl extends AutowireDaoSupport implements StudentDao {
    @Override
    public List<Student> queryInfoAll() {
        List<Student> studentList = getJdbcTemplate().query("SELECT * FROM student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int arg1) throws SQLException {
                Student student = new Student();
                student.setSid(rs.getInt(1));
                student.setSname(rs.getString(2));
                student.setAge(rs.getInt(3));
                return student;
            }
        });
        return studentList;
    }

    @Override
    public List<Student> queryInfoAllLimit(int start, int limit) {
        List<Map<String, Object>> mapList = getJdbcTemplate().queryForList("SELECT * FROM student limit ?,?",start,limit);
        List<Student> studentList = new ArrayList<Student>();
        for (Map<String,Object> map : mapList){
            Student student = new Student();
            student.setSid((Integer) map.get("sid"));
            student.setSname((String) map.get("sname"));
            student.setAge((Integer) map.get("age"));
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public Student queryInfoById(int sid) {
        List<Map<String, Object>> studentList = getJdbcTemplate().queryForList("SELECT * FROM student WHERE sid=?", sid);
        Map<String, Object> map = studentList.get(0);
        Student student = new Student();
        student.setSid((Integer) map.get("sid"));
        student.setSname((String) map.get("sname"));
        student.setAge((Integer) map.get("age"));
        return student;
    }

    @Override
    public boolean createInfo(Student student) {
        int height = getJdbcTemplate().update("INSERT INTO student VALUES (?,?,?)", student.getSid(), student.getSname(), student.getAge());
        return (height > 0) ? true : false;
    }

    @Override
    public boolean updateInfo(Student student) {
        int height = getJdbcTemplate().update("UPDATE student SET sname=?,age=? WHERE sid=?", student.getSname(), student.getAge(), student.getSid());
        return (height > 0) ? true : false;
    }

    @Override
    public boolean deleteInfo(int sid) {
        int height = getJdbcTemplate().update("DELETE FROM student WHERE sid=?", sid);
        return (height > 0) ? true : false;
    }
}
