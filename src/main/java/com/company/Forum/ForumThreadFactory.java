package com.company.Forum;

public class ForumThreadFactory {
    public ForumThread CreateForumThread(int type, String name, String description){
        switch (type){
            case 1:
                return new NormalForumThread(name,description);
            case 2:
                return new ForumThreadAttachedToBacklogItem(name,description);
        }
        return new NormalForumThread("FOUTJE","MOET KUNNEN BAAS");
    }
}
