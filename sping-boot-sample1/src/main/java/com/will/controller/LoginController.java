package com.will.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.will.bean.UserBean;

/**
 * 文件名：LoginController.java
 * 描述：
 * 作者：王承
 * 日期：2017年9月27日下午5:13:27
 */
@RestController
public class LoginController {
	
	/**
	 * 
	 * @param mv
	 * @return
	 * 作者：王承
	 * 日期：2017年9月27日下午5:14:47
	 */
	@RequestMapping("/login")
	public ModelAndView toLogin(ModelAndView mv){
		mv.setViewName("login");
		return mv;
	}
	
	/**
	 * 
	 * @param mv
	 * @return
	 * 作者：王承
	 * 日期：2017年9月27日下午5:56:31
	 */
	@RequestMapping("/index")
	public ModelAndView doLogin(UserBean userBean){
		return new ModelAndView("index");
	}

}
