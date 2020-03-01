package com.company.Forum;

import java.util.ArrayList;

public class Forum {
    private ArrayList<ForumThread> forumThreads;

    public Forum() {
        forumThreads = new ArrayList<>();
    }

    public void AddForumThread(ForumThread forumThread){
        forumThreads.add(forumThread);
    }

    public void PrintAllForumThreads(){
        System.out.println("Er zijn " + forumThreads.size() + " forumthreads:");
        for (ForumThread f:forumThreads
             ) {
            System.out.println(""+f.GetName()+",");
        }
    }
}
