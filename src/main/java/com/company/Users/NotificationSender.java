package com.company.Users;

import com.company.Users.User;

public interface NotificationSender {
    void SendNotification(User u, String message);
}
