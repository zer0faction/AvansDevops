package com.company.Users;

public class EmailAdapter implements NotificationSender{
    private EmailService emailService;

    public EmailAdapter() {
        emailService = new EmailService();
    }

    @Override
    public void SendNotification(User u, String message) {
        String email = u.getEmail();
        emailService.SendMessageUsingEmail(email, message);
    }
}
