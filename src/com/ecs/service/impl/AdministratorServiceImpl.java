package com.ecs.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecs.bean.Administrator;
import com.ecs.common.HibernateSessionFactory;
import com.ecs.common.exception.AdministratorServiceException;
import com.ecs.dao.AdministratorDao;
import com.ecs.service.IAdministratorService;
/*
 * service
 * 处理事务
 * */
public class AdministratorServiceImpl implements IAdministratorService{
	private AdministratorDao administratorDao=new AdministratorDao();
	@Override
	public Administrator login(String name, String password)
			throws AdministratorServiceException {
		Session session=HibernateSessionFactory.getsession();
		//开启事务
		Transaction tran=session.beginTransaction();
		/*
		 * 1.通过name找到admin
		 * 2.对比密码
		 * */
		Administrator admin=administratorDao.getAdminByName(name);
		if(admin!=null){
			if(admin.getPassword().equals(password)){
				tran.commit();
				session.close();
				return admin;
			}else{
				/*
				 * 简单的说 就是几张不同的表 你同时提交，如果前面提交的数据正确，而后面提交的数据错误，
				 * 正常来说，前面会提交成功。rollback的作用就是 一定要全部正确才会提交，
				 * 任何一张错误都会是事物回滚，不再提交。 
				 * */
				tran.rollback();
				session.close();
				throw new AdministratorServiceException("登陆失败，密码错误！");
			}
		}else{
			tran.rollback();
			session.close();
			throw new AdministratorServiceException("登陆失败，该管理员不存在！");
		}
	}

	@Override
	public void register(Administrator admin)
			throws AdministratorServiceException {
		Session session=HibernateSessionFactory.getsession();
		//开启事务
		Transaction tran=session.beginTransaction();
		//处理事务，先调用Dao层代码
		//先判断该用户名是否已被占用，如果占用，抛异常
		Administrator dbAdmin=administratorDao.getAdminByName(admin.getName());
		if(dbAdmin==null){
			administratorDao.addAdministrator(admin);
			tran.commit();
			session.close();
		}else{
			tran.rollback();
			session.close();
			throw new AdministratorServiceException("该用户名已被占用");
		}
	}
	

	@Override
	public List<Administrator> listAllAdministrators()
			throws AdministratorServiceException {
		List<Administrator> admins=administratorDao.findAllAdministrator();
		return admins;
	}

}
