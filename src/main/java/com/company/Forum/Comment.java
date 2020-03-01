package com.company.Forum;

import com.company.Users.User;

public class Comment {
    private String commentText;
    private User user;

    public Comment(String commentText, User user) {
        this.commentText = commentText;
        this.user = user;
    }

    public String getCommentText() {
        return commentText;
    }

    public User getUser() {
        return user;
    }
}
