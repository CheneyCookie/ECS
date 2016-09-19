package com.ecs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ecs.bean.User;
import com.ecs.common.HibernateSessionFactory;

/*
 * 对用户的增删改查
 * 
 * 1.不涉及事务的管理
 * 2.不涉及判断
 * */
public class UserDao {
	public Session getSession(){
		return HibernateSessionFactory.getsession();
	}
	public void addUser(User use){
		getSession().save(use);
	}
	public User getUseByName(String name){
		String hql="from User where name=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, name);
		//查找所有满足条件的值
		List<User> list=query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public List<User> findAllStudent(){
		String hql="from User";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	public void updatePassword(User use){
		getSession().update(use);
	}
}
