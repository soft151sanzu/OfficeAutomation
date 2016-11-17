package com.zhangly.util;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * Created by 青葉 on 2016/11/8.
 */
public class TestDataSource extends BasicDataSource {
    public TestDataSource(){
        super();
        setDriverClassName("com.mysql.jdbc.Driver");
        setUrl("jdbc:mysql://localhost:3306/test");
        setUsername("root");
        setPassword("root");
    }
}
