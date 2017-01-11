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
 * �ʼ����͹���
 * */
public class SendEmail {
	private static final String HOST = "smtp.163.com";// �ʼ���������ַ
	private static final String PROTOCOL = "SMTP";// Э��
	private static final int PORT = 25;// �˿�
	private static final String FROM = "a1801882392@163.com";// �����˵�email
	private static final String PWD = "547926122";// ����������

	/**
	 * ��ȡSession
	 */
	private static Session getSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);// ���÷�������ַ
		props.put("mail.store.protocol", PROTOCOL);// ����Э��
		props.put("mail.smtp.port", PORT);// ���ö˿�
		props.put("mail.smtp.auth", true);// ������֤.���Ϊtrue��Ҫ����Ӧ����֤����
		Authenticator authenticator = new Authenticator() {// ͨ��ʵ�ָýӿ������û���֤
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PWD);
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);
		return session;
	}

	/**
	 * �����ʼ��ķ���
	 */
	public static void send(String toEmail, String content) {
		// ��ȡ�����ʼ���Session
		Session session = getSession();
		try {
			System.out.println("----send" + content);
			// ʵ�����ʼ����Ͷ���
			Message msg = new MimeMessage(session);

			// ������Ϣ����
			msg.setFrom(new InternetAddress(FROM));
			InternetAddress[] address = { new InternetAddress(toEmail) };// ������Ϣ������
			msg.setRecipients(Message.RecipientType.TO, address);// �����ʼ���ָ���������ַ
			msg.setSubject("�˺ż����ʼ�");// ����
			msg.setSentDate(new Date());// �ʼ�����ʱ��
			msg.setContent(content, "text/html;charset=utf-8");// �ʼ�����
			// �����ʼ�
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
