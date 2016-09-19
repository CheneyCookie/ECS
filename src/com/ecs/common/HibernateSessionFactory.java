package com.ecs.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	//线程变量，每个线程中都拥有一个，并且该变量在不同线程中不可共享
	private static final ThreadLocal<Session> threaLocal=
			new ThreadLocal<Session>();
	static{
		Configuration config=new Configuration();
		config.configure();
		factory=config.buildSessionFactory();
	}
	/*
	 * 获取session
	 * 当当前线程中没有session的时候，创建，创建后将其放入当前线程中
	 * 当当前线程中有session，直接返回
	 * */
	public static Session getsession(){
		Session session=threaLocal.get();
		if(session==null||!session.isOpen()){
			session=factory.openSession();
			threaLocal.set(session);
		}
		return session;
	}
}
