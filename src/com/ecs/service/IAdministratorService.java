package com.ecs.service;

import java.util.List;

import com.ecs.bean.Administrator;
import com.ecs.common.exception.AdministratorServiceException;

public interface IAdministratorService {
	/*
	 * 登陆
	 * */
	Administrator login(String name,String password) throws AdministratorServiceException;
	/*
	 * 注册
	 * 将管理员-->数据库
	 * */
	void register(Administrator admin) throws AdministratorServiceException;
	/*
	 * 列出所有管理员
	 * */
	List<Administrator> listAllAdministrators() throws AdministratorServiceException;
	
}
