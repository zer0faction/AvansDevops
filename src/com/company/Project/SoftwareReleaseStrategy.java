package com.company.Project;

public class SoftwareReleaseStrategy implements EndOfSprintBehaviour {
    @Override
    public void SprintFinished() {
        System.out.println("Software release strategy");
    }
}
