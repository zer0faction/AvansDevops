package com.company.ReportGenerator;

public class PdfGenerator extends ReportGenerator {

    @Override
    public void SetReportColors(){
        System.out.println("Set colors for PDF doc");
    }

    @Override
    public void SetReportHeader() {
        System.out.println("Set header for PDF doc");
    }

    @Override
    public void SetReportFooter() {
        System.out.println("Set footer for PDF doc");
    }

    @Override
    public String ReturnDocument(){
        return "PDF";
    }
}
