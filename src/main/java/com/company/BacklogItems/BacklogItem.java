package com.company.BacklogItems;

import com.company.Users.User;

import java.util.ArrayList;

public class BacklogItem {
    private String name;
    private String description; //1

    private BacklogItemState backlogItemState;
    private ArrayList<BacklogTask> backlogTasks;

    public BacklogItem(String name, String description, User user) {
        this.name = name;
        this.backlogItemState = new ToDoState(this);
        backlogTasks = new ArrayList<BacklogTask>();
        BacklogTask b = new BacklogTask(name, description, user);
        backlogTasks.add(b);
    }

    public void SetState(BacklogItemState b){
        this.backlogItemState = b;
    }

    public void GoNext(){
        backlogItemState.GoNext();
    }

    public void SetBackToToDo(){
        backlogItemState.SetBackToToDo();
    }

    public ArrayList<BacklogTask> GetBacklogTasks(){
        return backlogTasks;
    }

    public void AddExtraBacklogTask(String name, String description, User user){
        BacklogTask b = new BacklogTask(name, description, user);
        backlogTasks.add(b);
    }

    public BacklogItemState GetState(){
        return backlogItemState;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> GetAllUsersAttachedToBacklogItem(){

        ArrayList<User> users = new ArrayList<>();
        for (BacklogTask b: backlogTasks
             ) {
            users.add(b.getUser());
        }
        return users;
    }
}
