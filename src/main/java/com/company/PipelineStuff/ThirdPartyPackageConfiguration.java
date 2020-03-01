package com.company.PipelineStuff;

import java.util.ArrayList;

public class ThirdPartyPackageConfiguration {
    private ArrayList<String> thirdPartyAddOns;
    private ThirdPartyPackageInstallerService thirdPartyPackageInstallerService;

    public ThirdPartyPackageConfiguration() {
        thirdPartyAddOns = new ArrayList<>();
        thirdPartyPackageInstallerService = new ThirdPartyPackageInstallerService();
    }

    public void AddThirdPartyAddOn(String addOn){
        thirdPartyAddOns.add(addOn);
    }

    public void RemoveThirdPartyAddOn(String addOn){
        thirdPartyAddOns.remove(addOn);
    }

    public boolean installPackages(){
        boolean succes = true;
        for (String s:thirdPartyAddOns
             ) {
            if(!thirdPartyPackageInstallerService.DownloadAndInstallThirdpartyPackage(s)){
                succes = false;
            }
        }
        return succes;
    }
}
