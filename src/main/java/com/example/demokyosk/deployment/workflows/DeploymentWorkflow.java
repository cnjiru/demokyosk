package com.example.demokyosk.deployment.workflows;//package app.example.example.deployment.deployment.temporal.workflows;

import deployment.deployment.v1.Deployment;
import deployment.software_release.v1.SoftwareRelease;
import deployment.artifact.v1.Artifact;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
/**
 * @author muchembi
 * @date 08/07/2024
 * https://github.com/muchembi
 */
@WorkflowInterface // It is a placeholder method to enable testing.
public interface DeploymentWorkflow {
    @WorkflowMethod
    Deployment startDeployment(SoftwareRelease dw, Artifact art, String workflowId);

}
