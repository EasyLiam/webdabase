package com.webdata.service.impl;

import org.springframework.stereotype.Service;

import com.webdata.service.UserService;
import com.webdata.utils.SendEmail;

@Service
public class UserServiceImpl implements UserService {
	// �ʼ����Ͷ���
	public void processregister(String email) {
		// �ʼ�������
		StringBuffer sb = new StringBuffer(
				"����������Ӽ����˺ţ�48Сʱ��Ч����������ע���˺ţ�����ֻ��ʹ��һ�Σ��뾡�켤��!");
		sb.append("<a href='http://localhost:8080'></a>");
		sb.append(email);
		// �����ʼ�
		SendEmail.send(email, sb.toString());
		System.out.println("�����ʼ�");
	}

}
