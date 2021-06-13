package com.kouhou.jee.ServiceImpl;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Exception.MyException;
import com.kouhou.jee.Service.MailService;
import com.kouhou.jee.entities.NotificationEmail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
public class MailServerImpl{
/*
	private final JavaMailSender mailSender;
	private final MailContentBuilder mailContentBuilder;
	
	@Async
	public void sendEmail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagePreparator = mimeMessage ->{
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("watchIt-cinema@email.com");
			messageHelper.setTo(notificationEmail.getRecipient());
			messageHelper.setSubject(notificationEmail.getSubject());
			messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
			
		};
		try {
			mailSender.send(messagePreparator);
			log.info("A verification email sent to "+notificationEmail.getRecipient());
		}
		catch(MailException e){
			e.printStackTrace();
				//throw new MyException("error during sending notification message");
		}
	}*/
}
