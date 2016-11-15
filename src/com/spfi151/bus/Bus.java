package com.spfi151.bus;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bus {
 public void pus(String name){
	 System.out.println("他的名叫"+name);
    int i=1/0;
 }
 public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("mas.xml");
	Bus bus=(Bus) ctx.getBean("qm");
	bus.pus("张三");
}
}
