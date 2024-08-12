package com.example.demokyosk.softwarerelease.temporal.workflows;//package app.example.example.deployment.softwarerelease.temporal.workflows;

import deployment.software_release.v1.SoftwareRelease;
import deployment.artifact.v1.Artifact;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;


@WorkflowInterface
public interface SoftwareReleaseWorkflow {

    @WorkflowMethod
    SoftwareRelease startSoftwareReleaseWorkflow(Artifact art, String workflowId);
}
