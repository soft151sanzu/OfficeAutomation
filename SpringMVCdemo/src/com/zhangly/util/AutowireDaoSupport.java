package com.zhangly.util;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 自动注入工具类，该类继承JdbcDaoSupport，避免了Dao层直接和JdbcDaoSupport耦合
 */
public class AutowireDaoSupport extends JdbcDaoSupport
	implements ApplicationContextAware {

	/**
	 * 若需要测试则需要解开注释
	 * 该构造方法在实例化的时候调用setApplicationContext进行初始化
	 * 没有启动Tomcat的时候不会扫描xml
	 * 需要手动注入数据源
	 */
//    public AutowireDaoSupport(){
//        setApplicationContext(null);
//    }

	@Override
	public void setApplicationContext(ApplicationContext ctx){
		//手动获得数据源，若开始Tomcat则注释
		//DataSource dataSource = new TestDataSource();
		//自动获得数据源，若没开启Tomcat则注释
		DataSource dataSource = (DataSource) ctx.getBean("ds");
		//将数据源注入JdbcDaoSupport，此处调用的是父类属性的set方法
		setDataSource(dataSource);
	}

}
