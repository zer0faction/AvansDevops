package com.company.Forum;

import com.company.BacklogItems.BacklogItem;
import com.company.BacklogItems.DoneState;

import java.util.ArrayList;

public class ForumThreadAttachedToBacklogItem implements ForumThread {
    private String name;
    private String description;
    private ArrayList<Comment> comments;
    private BacklogItem backlogItemAttachedToThisThread;

    public ForumThreadAttachedToBacklogItem(String name, String description) {
        this.name = name;
        this.description = description;
        this.backlogItemAttachedToThisThread = backlogItemAttachedToThisThread;
        comments = new ArrayList<>();
    }

    public void AddComment(Comment c){
        if(backlogItemAttachedToThisThread.GetState() instanceof DoneState){
            System.out.println("Cannot add comment. BacklogItem is already DONE");
        } else {
            comments.add(c);
        }
    }

    @Override
    public BacklogItem GetBacklogItemAttachedToThread() {
        return backlogItemAttachedToThisThread;
    }

    @Override
    public void PrintAllComments(){
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
