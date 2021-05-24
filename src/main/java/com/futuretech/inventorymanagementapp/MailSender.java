package com.futuretech.inventorymanagementapp;

public interface MailSender {

	void sendText(String from, String to, String subject, String body);
    void sendHTML(String from, String to, String subject, String body);
}
