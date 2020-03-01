package com.company.BacklogItems;

public class ToDoState extends BacklogItemState {

    BacklogItem context;

    public ToDoState(BacklogItem context) {
        this.context = context;
    }

    @Override
    public void GoNext() {
        System.out.println("Set State of backlogitem to DOING");
        context.SetState(new DoingState(context));
    }
}
