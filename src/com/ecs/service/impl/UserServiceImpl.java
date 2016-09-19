package com.ecs.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecs.bean.User;
import com.ecs.common.HibernateSessionFactory;
import com.ecs.common.exception.UserServiceException;
import com.ecs.dao.UserDao;
import com.ecs.service.IUserService;
	/*
	 * service
	 * 处理事务
	 * */
public class UserServiceImpl implements IUserService{
	private UserDao userDao=new UserDao();
	@Override
	public User login(String name, String password) throws UserServiceException {
		Session session=HibernateSessionFactory.getsession();
		//开启事务
		Transaction tran=session.beginTransaction();
		//1.通过name找到use
		//2.对比密码
		User use=userDao.getUseByName(name);
		if(use!=null){
			if(use.getPassword().equals(password)){
				tran.commit();
				session.close();
				return use;
			}else{
				tran.rollback();
				session.close();
				throw new UserServiceException("登录失败，密码错误！");
			}
		}else{
			tran.rollback();
			session.close();
			throw new UserServiceException("登录失败，该用户名不存在！");
		}
	}

	@Override
	public void register(User use) throws UserServiceException {
		Session session=HibernateSessionFactory.getsession();
		//开启事务
		Transaction tran=session.beginTransaction();
		//处理事务，调用Dao层代码
		//先判断该用户名是否已被占用，如果占用，抛异常
		User dbuse=userDao.getUseByName(use.getName());
		if(dbuse==null){
			userDao.addUser(use);
			tran.commit();
			session.close();
		}else{
			tran.rollback();
			session.close();
			throw new UserServiceException("该用户名已被占用！");
		}
	}

	@Override
	public List<User> listAllUser() throws UserServiceException {
		List<User> uses=userDao.findAllStudent();
		return uses;
	}
}
