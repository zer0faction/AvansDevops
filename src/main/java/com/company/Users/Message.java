package com.company.Users;

import java.util.ArrayList;

public class Message {

    private String message;
    private ArrayList<MessageSubscriber> subscribers;

    public Message(String message) {
        this.message = message;
        subscribers = new ArrayList<>();
    }

    public void Subscribe(MessageSubscriber messageSubscriber){
        subscribers.add(messageSubscriber);
    }

    public void UnSubscribe(MessageSubscriber messageSubscriber){
        subscribers.remove(messageSubscriber);
    }

    public void NotifySubscribers(){
        for (MessageSubscriber m: subscribers
        ) {
            m.Update(message);
        }
    }

}
