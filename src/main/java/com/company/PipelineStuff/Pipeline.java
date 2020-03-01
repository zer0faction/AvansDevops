package com.company.PipelineStuff;

public class Pipeline {
    private PipelineOptions pipelineOptions;

    public Pipeline(PipelineOptions pipelineOptions) {
        pipelineOptions = new PipelineOptions();
    }

    public void RunPipeline(){
        pipelineOptions.RunPipeline();
    }

    public PipelineOptions getPipelineOptions() {
        return pipelineOptions;
    }
}
