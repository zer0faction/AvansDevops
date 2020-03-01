package com.company.PipelineStuff;

import java.util.ArrayList;

public class PipelineOptions {
    private DeploymentConfiguration deploymentConfiguration;
    private AnalyticsConfiguration analyticsConfiguration;
    private TestConfiguration testConfiguration;
    private BuildConfiguration buildConfiguration;
    private ThirdPartyPackageConfiguration thirdPartyPackageConfiguration;
    private ArrayList<UtilityConfiguration> utilityConfigurations;

    public PipelineOptions() {
        this.deploymentConfiguration = new DeploymentConfiguration();
        this.analyticsConfiguration = new AnalyticsConfiguration();
        this.testConfiguration = new TestConfiguration();
        this.buildConfiguration = new BuildConfiguration();
        this.thirdPartyPackageConfiguration = new ThirdPartyPackageConfiguration();
        this.utilityConfigurations = new ArrayList<>();
    }

    public void RunPipeline(){
        thirdPartyPackageConfiguration.installPackages();
        buildConfiguration.BuildTheCode();
        //testc...
        analyticsConfiguration.DoCodeAnalysis();
        deploymentConfiguration.DeployToService();
        for (UtilityConfiguration u:utilityConfigurations
             ) {
            u.RunUtility();
        }
    }

    public void SetAnalyticTool(){
        //Niet geimplementeerd. Normaal gesproken zou je hier de Adapter setten voor de tool die je wilt gebruiken.
        //analyticsConfiguration.setTool(ADAPTER);
    }

    public void SetDeploymentTarget(){
        //Niet geimplementeerd. Normaal gesproken zou je hier de Adapter setten voor de tool die je wilt gebruiken.
        //deploymentConfiguration.setTool(ADAPTER);
    }

    public void SetBuildConfiguration(){
        //Niet geimplementeerd. Normaal gesproken zou je hier de Adapter setten voor de tool die je wilt gebruiken.
        //buildConfiguration.setTool(ADAPTER);
    }

    public void AddThirdPartyPackage(String s){
        thirdPartyPackageConfiguration.AddThirdPartyAddOn(s);
    }

    public void AddTestPackage(String s) { testConfiguration.AddThirdPartyAddOn(s); };

    public void AddUtility(UtilityConfiguration u){
        utilityConfigurations.add(u);
    }

    public void RemoveUtility(UtilityConfiguration u){
        utilityConfigurations.remove(u);
    }
}
