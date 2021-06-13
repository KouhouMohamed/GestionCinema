package com.kouhou.jee.Service;

import com.kouhou.jee.entities.NotificationEmail;

public interface MailService {

	public void sendEmail(NotificationEmail notificationEmail);
}
