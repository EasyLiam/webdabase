package com.webdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webdata.service.impl.UserServiceImpl;

@Controller
public class UserController {
	UserServiceImpl us=new UserServiceImpl();
	/**
	 * ��ת��ע��ҳ��
	 */
	@RequestMapping("/regist")
	public String regist() {
		
		return "regist";
	}
	
}
