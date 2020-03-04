package com.company.Project;

import com.company.BacklogItems.BacklogItem;
import com.company.Users.User;

import java.util.ArrayList;
import java.util.Date;

public class Sprint {

    private String name;
    private Date startDate;
    private Date endDate;
    private User sprintMaster;
    private ArrayList<BacklogItem> sprintBacklog;

    private SprintState state;
    private EndOfSprintBehaviour endOfSprintBehaviour;

    public Sprint(String name, Date startDate, Date endDate, User sprintMaster, EndOfSprintBehaviour endOfSprintBehaviour) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sprintMaster = sprintMaster;

        ArrayList<BacklogItem> sprintBacklog = new ArrayList<>();
        this.sprintBacklog = sprintBacklog;
        state = new PlanningState(this);
        this.endOfSprintBehaviour = endOfSprintBehaviour;
    }

    public void SetSprintData(String name, Date startDate, Date endDate) {
        state.SetSprintData(name,startDate,endDate);
    }

    public void SprintEnds(){
        endOfSprintBehaviour.SprintFinished();
    }

    public void AddBacklogItem(BacklogItem b){
        state.AddBacklogItem(b);
    }

    public void AddBackLogItemToSprintBackLog(BacklogItem b){
        sprintBacklog.add(b);
    }

    public void GoNext(){
        state.GoNext();
    }

    public void SetState(SprintState state){
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }
}
