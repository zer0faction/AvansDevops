package com.company.Project;

import com.company.BacklogItems.BacklogItem;

import java.util.Date;

public abstract class SprintState {
    public abstract void GoNext();

    public void SetSprintData(String name, Date startDate, Date endDate){
        System.out.println("Error: com.company.Project.Sprint data cannot be set. com.company.Project.Sprint has already started.");
    }

    public void AddBacklogItem(BacklogItem b){
        System.out.println("Error: Cannot add backlogitem. com.company.Project.Sprint has already started.");
    }
}
