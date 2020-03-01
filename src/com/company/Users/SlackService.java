package com.company.Users;

public class SlackService {

    public void SendMessageUsingSlack(String slackUsername, String message){
        System.out.println("Stuur de message: " + message + " naar de slack gebruiker: " + slackUsername);
    }
}
