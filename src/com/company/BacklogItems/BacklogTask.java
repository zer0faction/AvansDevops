package com.company.BacklogItems;

import com.company.Users.User;

public class BacklogTask {
    private String name;
    private String description;
    private User user;
    private boolean isDone;

    public BacklogTask(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
        isDone = false;
    }

    public void SetBackLogTaskToDone(){
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }

    public User getUser() {
        return user;
    }
}
