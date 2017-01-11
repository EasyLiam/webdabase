package com.webdata.service.impl;

import org.springframework.stereotype.Service;

import com.webdata.service.UserService;
import com.webdata.utils.SendEmail;

@Service
public class UserServiceImpl implements UserService {
	// 邮件发送对象
	public void processregister(String email) {
		// 邮件的内容
		StringBuffer sb = new StringBuffer(
				"点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活!");
		sb.append("<a href='http://localhost:8080'></a>");
		sb.append(email);
		// 发送邮件
		SendEmail.send(email, sb.toString());
		System.out.println("发送邮件");
	}

}
