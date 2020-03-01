package com.company.Forum;

import com.company.BacklogItems.BacklogItem;

import java.util.ArrayList;

public class NormalForumThread implements ForumThread {
    private String name;
    private String description;
    private ArrayList<Comment> comments;

    public NormalForumThread(String name, String description) {
        this.name = name;
        this.description = description;
        comments = new ArrayList<>();
    }

    @Override
    public void AddComment(Comment c) {
        comments.add(c);
    }

    @Override
    public BacklogItem GetBacklogItemAttachedToThread() {
        System.out.println("Er is geen backlogitem die vastzit aan deze thread.");
        return null;
    }

    @Override
    public void PrintAllComments() {
        for (Comment c:comments
        ) {
            System.out.println(c.getUser().getName() + " heeft het volgende gecomment: " + c.getCommentText());
        }
    }

    @Override
    public String GetName() {
        return name;
    }
}
