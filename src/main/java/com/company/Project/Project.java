package com.company.Project;

import com.company.BacklogItems.BacklogItem;
import com.company.Forum.Forum;
import com.company.Users.User;

import java.util.ArrayList;

public class Project {
    private String name;
    private String description;
    private User productOwner;
    private ArrayList<BacklogItem> productBacklog;
    private ArrayList<Sprint> sprints;
    private Forum projectForum;

    public Project(String name, String description, User productOwner, ArrayList<BacklogItem> productBacklog, ArrayList<Sprint> sprints) {
        this.name = name;
        this.description = description;
        this.productOwner = productOwner;
        this.productBacklog = productBacklog;
        this.sprints = sprints;
        Forum projectForum = new Forum();
        this.projectForum = projectForum;
    }

    public void AddSprint(Sprint s){
        sprints.add(s);
    }

    public void AddBacklogItem(BacklogItem b){
        productBacklog.add(b);
    }

    public Forum getProjectForum() {
        return projectForum;
    }
}
