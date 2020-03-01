package com.company.Users;

import java.util.ArrayList;

public class User implements MessageSubscriber {
    private String name;
    private String email;
    private String slackUsername;
    private ArrayList<NotificationSender> subscribers;

    public User() {
        subscribers = new ArrayList<>();
    }

    public void Subscribe(NotificationSender notificationSender){
        subscribers.add(notificationSender);
    }

    public void UnSubscribe(NotificationSender notificationSender){
        subscribers.remove(notificationSender);
    }
    
    public void NotifySubscribers(String message){
        for (NotificationSender n: subscribers
             ) {
            n.SendNotification(this, message);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlackUsername() {
        return slackUsername;
    }

    public void setSlackUsername(String slackUsername) {
        this.slackUsername = slackUsername;
    }

    @Override
    public void Update(String message) {
        NotifySubscribers(message);
    }
}
