package com.company.BacklogItems;

import com.company.Users.Message;
import com.company.Users.User;

public class DoneState extends BacklogItemState {

    BacklogItem context;

    public DoneState(BacklogItem context) {
        this.context = context;
    }

    @Override
    public void GoNext() {
        System.out.println("State of backlogitem is DONE, can't go any further");
    }

    @Override
    public void SetBackToToDo(){
        context.SetState(new ToDoState(context));
        System.out.println("Zet terug naar TODO");
        Message m = new Message("backlogitem " + context.getName() + " is teruggezet naar TODO.");

        for (User u:context.GetAllUsersAttachedToBacklogItem()
             ) {
            m.Subscribe(u);
        }
        m.NotifySubscribers();
    }
}
