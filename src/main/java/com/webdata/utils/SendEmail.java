package com.webdata.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具
 * */
public class SendEmail {
	private static final String HOST = "smtp.163.com";// 邮件服务器地址
	private static final String PROTOCOL = "SMTP";// 协议
	private static final int PORT = 25;// 端口
	private static final String FROM = "a1801882392@163.com";// 发件人的email
	private static final String PWD = "547926122";// 发件人密码

	/**
	 * 获取Session
	 */
	private static Session getSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);// 设置服务器地址
		props.put("mail.store.protocol", PROTOCOL);// 设置协议
		props.put("mail.smtp.port", PORT);// 设置端口
		props.put("mail.smtp.auth", true);// 发送论证.如果为true就要有相应的论证机制
		Authenticator authenticator = new Authenticator() {// 通过实现该接口用于用户认证
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PWD);
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);
		return session;
	}

	/**
	 * 发送邮件的方法
	 */
	public static void send(String toEmail, String content) {
		// 获取发送邮件的Session
		Session session = getSession();
		try {
			System.out.println("----send" + content);
			// 实例化邮件发送对象
			Message msg = new MimeMessage(session);

			// 设置消息属性
			msg.setFrom(new InternetAddress(FROM));
			InternetAddress[] address = { new InternetAddress(toEmail) };// 接受信息的邮箱
			msg.setRecipients(Message.RecipientType.TO, address);// 发送邮件给指定的邮箱地址
			msg.setSubject("账号激活邮件");// 标题
			msg.setSentDate(new Date());// 邮件发送时间
			msg.setContent(content, "text/html;charset=utf-8");// 邮件内容
			// 发送邮件
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
