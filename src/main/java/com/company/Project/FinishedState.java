package com.company.Project;

public class FinishedState extends SprintState {

    Sprint context;

    public FinishedState(Sprint context) {
        this.context = context;
    }

    @Override
    public void GoNext() {
        System.out.println("Cant go any further");
    }
}
