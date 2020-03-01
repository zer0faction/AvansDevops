package com.company.Users;

public class SlackAdapter implements NotificationSender {
    private SlackService slackService;

    public SlackAdapter() {
        slackService = new SlackService();
    }

    @Override
    public void SendNotification(User u, String message) {
        String slackUsername = u.getSlackUsername();
        slackService.SendMessageUsingSlack(slackUsername, message);
    }
}
