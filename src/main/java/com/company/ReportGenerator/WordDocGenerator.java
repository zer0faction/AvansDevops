package com.company.ReportGenerator;

public class WordDocGenerator extends ReportGenerator{
    @Override
    public void SetReportColors(){
        System.out.println("Set colors for WORD doc");
    }

    @Override
    public void SetReportHeader() {
        System.out.println("Set header for WORD doc");
    }

    @Override
    public void SetReportFooter() {
        System.out.println("Set footer for WORD doc");
    }
}
