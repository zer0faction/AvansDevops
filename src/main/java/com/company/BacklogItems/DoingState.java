package com.company.BacklogItems;

public class DoingState extends BacklogItemState {

    BacklogItem context;

    public DoingState(BacklogItem context) {
        this.context = context;
    }

    @Override
    public void GoNext() {
        boolean areAllBacklogTasksDone = true;
        for (BacklogTask b:context.GetBacklogTasks()
             ) {
            if(!b.isDone()){
                areAllBacklogTasksDone = false;
            }
        }

        if(areAllBacklogTasksDone){
            System.out.println("Set State of backlogitem to DONE");
            context.SetState(new DoneState(context));
        } else {
            System.out.println("Error: cannot set backlogitem to DONE, not all backlog tasks are done yet.");
        }
    }
}
