package com.company.ReportGenerator;

import com.company.Project.Sprint;
import com.company.Users.Message;
import com.company.Users.User;

import java.util.ArrayList;

public abstract class ReportGenerator {

    public void SetReportColors(){}
    public void SetReportHeader(){}
    public void SetReportFooter(){}

    public void GenerateReport(Sprint sprint, ArrayList<User> users){
        SetReportText("");
        SetReportColors();
        SetReportHeader();
        SetReportFooter();
        SaveReportToDatabase();
        SendReportToUsers(users);
    }

    public void SetReportText(String text){
        System.out.println("Setting text of report: " + text);
    }

    public void SaveReportToDatabase(){
        System.out.println("Saving report to database");
    }

    public void SendReportToUsers(ArrayList<User> users){
        Message m = new Message("A new report has been created");
        for (User u:users
             ) {
            m.Subscribe(u);
        }
    }
}
