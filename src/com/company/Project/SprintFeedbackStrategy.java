package com.company.Project;

public class SprintFeedbackStrategy implements EndOfSprintBehaviour {
    @Override
    public void SprintFinished() {
        System.out.println("FeedbackStrategy");
    }
}
