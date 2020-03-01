package com.company.PipelineStuff;

public class ThirdPartyPackageInstallerService {
    public boolean DownloadAndInstallThirdpartyPackage(String s){
        System.out.println("Downloading package: " + s);
        System.out.println("Installing package: " + s);
        System.out.println("--- Installing complete ---");
        return true;
    }
}
