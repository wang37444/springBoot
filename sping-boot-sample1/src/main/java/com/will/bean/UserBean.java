package com.will.bean;

import java.io.Serializable;

/**
 * 文件名：UserBean.java
 * 描述：
 * 作者：王承
 * 日期：2017年9月27日下午6:06:19
 */
public class UserBean implements Serializable{

	/** */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String userPwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	

}
