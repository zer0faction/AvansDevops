package com.company.Project;

public class ImplementationState extends SprintState {
    Sprint context;

    public ImplementationState(Sprint context) {
        this.context = context;
    }

    @Override
    public void GoNext() {
        System.out.println("Set sprint to finished state");
        context.SetState(new FinishedState(context));
        context.SprintEnds();
    }
}
