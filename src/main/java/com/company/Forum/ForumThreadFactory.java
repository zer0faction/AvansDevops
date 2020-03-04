package com.company.Forum;

import com.company.BacklogItems.BacklogItem;

public class ForumThreadFactory {
    public ForumThread CreateForumThread(int type, String name, String description, BacklogItem backlogItemAttachedToThisThread){
        switch (type){
            case 1:
                return new NormalForumThread(name,description);
            case 2:
                return new ForumThreadAttachedToBacklogItem(name,description, backlogItemAttachedToThisThread);
        }
        return new NormalForumThread("FOUTJE","MOET KUNNEN BAAS");
    }
}
