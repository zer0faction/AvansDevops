package com.company.Forum;

import com.company.BacklogItems.BacklogItem;

public interface ForumThread {

    public void AddComment(Comment c);
    public BacklogItem GetBacklogItemAttachedToThread();
    public void PrintAllComments();
    public String GetName();
}
