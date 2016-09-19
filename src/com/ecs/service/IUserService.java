package com.ecs.service;

import java.util.List;

import com.ecs.bean.User;
import com.ecs.common.exception.UserServiceException;

public interface IUserService {
	/*
	 * 登录
	 * */
	User login(String name,String password) throws UserServiceException;
	/*
	 * 注册
	 * 将用户-->到数据库中
	 * */
	void register(User use) throws UserServiceException;
	/*
	 * 列出所有用户
	 * */
	List<User> listAllUser() throws UserServiceException;
}