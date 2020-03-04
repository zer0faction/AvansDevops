package com.company.Forum;

import com.company.BacklogItems.BacklogItem;

import java.util.ArrayList;

public interface ForumThread {
    public void AddComment(Comment c);
    public BacklogItem GetBacklogItemAttachedToThread();
    public void PrintAllComments();
    public String GetName();
    public void AddBacklogItem(BacklogItem b);
    public ArrayList<Comment> GetAllComments();
}
