package com.yedam.network;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailExample {

	public static void main(String[] args) throws AddressException, MessagingException {
		String host = "smtp.naver.com"; //mail서버(smtp)
		final String user = "tryntryagain@naver.com"; //ID
		final String passwd = "Mrtrader13#"; //비번
		
		String toUser = "whlee0413@gmail.com"; //받는메일주소.
		
		Properties props = new Properties();
		props.put("mail.smtp.host",host);//smtp set
		props.put("mail.smtp.port",587); //port
		props.put("mail.smtp.auth",true);//유효체크
		
		Session session	 = Session.getDefaultInstance (props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication ( user, passwd);
				
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toUser));
		
		message.setSubject("네이버 메일 테스트");//메일제목
		message.setText("대연띠"); //내용
		Transport.send(message); //메일발송
		System.out.println("mail sent");
		
	}

}
