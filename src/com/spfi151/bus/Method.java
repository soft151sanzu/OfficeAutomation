package com.spfi151.bus;

import org.aspectj.lang.ProceedingJoinPoint;

public class Method {
public void qianduan(){
	System.out.println("好像你");
}
public  void houduan(){
	System.out.println("不想你");
}
public void zhouwei(ProceedingJoinPoint pjp) throws Throwable{
	System.out.println("我想重新继续爱");
	pjp.proceed();
	System.out.println("我真的想继续那段爱");
}
public void yichang(){
	System.out.println("一点事也没用发生R了个狗");
}
public void zuizhong(){
	System.out.println("我只会执行完，不会帮你解决为题");
}
}
