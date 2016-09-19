package com.ecs.bean;

import java.io.Serializable;

/*实现serializable接口的作用是就是可以把对象存到字节流，
 * 一个类只有实现了Serializable接口，它的对象才是可序列化的
 * */
public class Administrator implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", password="
				+ password + "]";
	}
	
}
