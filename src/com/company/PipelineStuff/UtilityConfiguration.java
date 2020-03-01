package com.company.PipelineStuff;

public class UtilityConfiguration {
    private String type;

    public UtilityConfiguration(String type) {
        this.type = type;
    }

    public void RunUtility(){
        if(type.equals("BatchFile")){
            System.out.println("Running a batchfile");
        } else if(type.equals("CommandLineAction")){
            System.out.println("Performing a commandline action");
        } else if(type.equals("DownloadFile")){
            System.out.println("Downloading a file");
        } else {
            System.out.println("Geen file detected");
        }
    }
}
