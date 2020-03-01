package com.company.PipelineStuff;

import com.company.PipelineStuff.ThirdPartyPackageInstallerService;

import java.util.ArrayList;

public class TestConfiguration {
    private ArrayList<String> thirdPartyTestAddOns;
    private ThirdPartyPackageInstallerService thirdPartyPackageInstallerService;

    public TestConfiguration() {
        thirdPartyTestAddOns = new ArrayList<>();
        thirdPartyPackageInstallerService = new ThirdPartyPackageInstallerService();
    }

    public void AddThirdPartyAddOn(String addOn){
        thirdPartyTestAddOns.add(addOn);
    }

    public void RemoveThirdPartyAddOn(String addOn){
        thirdPartyTestAddOns.remove(addOn);
    }

    public boolean installPackages(){
        boolean succes = true;
        for (String s:thirdPartyTestAddOns
        ) {
            if(!thirdPartyPackageInstallerService.DownloadAndInstallThirdpartyPackage(s)){
                succes = false;
            }
        }
        return succes;
    }
}
