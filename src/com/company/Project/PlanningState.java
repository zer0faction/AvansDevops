package com.company.Project;

import com.company.BacklogItems.BacklogItem;

import java.util.Date;

public class PlanningState extends SprintState {

    Sprint context;

    public PlanningState(Sprint context) {
        this.context = context;
    }

    @Override
    public void GoNext() {
        System.out.println("Set sprint to implementation state");
        context.SetState(new ImplementationState(context));
    }

    @Override
    public void SetSprintData(String name, Date startDate, Date endDate){
        System.out.println("Setting data in sprint");
        context.setName(name);
        context.setStartDate(startDate);
        context.setEndDate(endDate);
    }

    @Override
    public void AddBacklogItem(BacklogItem b){
        System.out.println("Adding backlogitem to sprint");
        context.AddBackLogItemToSprintBackLog(b);
    }
}
