package com.javaweb.springmvc.Util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.javaweb.springmvc.Constants.Constants;
@Component
public class SendEmail {
	@Autowired
	JavaMailSender javaMailSender;
	public void sendEmail(String to,String subject,String content) {
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(Constants.MY_EMAIL);
		mailMessage.setTo(to);
		
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		
		javaMailSender.send(mailMessage);
	}
public void sendEmailTest(String to,String subject,String content) {
		
	try {            
        Email email = new SimpleEmail();

        // Cấu hình thông tin Email Server
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(Constants.MY_EMAIL,
                Constants.MY_PASSWORD));
         
        // Với gmail cái này là bắt buộc.
        email.setSSLOnConnect(true);
         
        // Người gửi
        email.setFrom(Constants.MY_EMAIL);
         
        // Tiêu đề
        email.setSubject(subject);
         
        // Nội dung email
        email.setMsg(content);
         
        // Người nhận
        email.addTo(to);            
        email.send();
        System.out.println("Sent!!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	}


