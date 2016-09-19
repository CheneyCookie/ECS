package com.ecs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ecs.bean.Administrator;
import com.ecs.common.HibernateSessionFactory;

/*
 * 对管理员的增删改查
 * 
 * 1.不涉及事务的管理
 * 2.不涉及判断
 * */
public class AdministratorDao {
	public Session getSession(){
		return HibernateSessionFactory.getsession();
	}
	public void addAdministrator(Administrator admin){
		getSession().save(admin);
	}
	public Administrator getAdminByName(String name){
		String hql="from Administrator where name=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, name);
		//查找所有满足条件的值
		List<Administrator> list=query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public List<Administrator> findAllAdministrator(){
		String hql="from Administrator";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
}
