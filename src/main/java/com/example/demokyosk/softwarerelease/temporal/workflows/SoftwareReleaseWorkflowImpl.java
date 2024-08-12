package com.example.demokyosk.softwarerelease.temporal.workflows;//package app.example.example.deployment.softwarerelease.temporal.workflows;

import com.example.demokyosk.deployment.workflows.DeploymentWorkflow;
import deployment.deployment.v1.Deployment;
import deployment.software_release.v1.SoftwareRelease;
import deployment.artifact.v1.Artifact;
import io.temporal.api.enums.v1.WorkflowIdReusePolicy;
import io.temporal.common.RetryOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Async;
import io.temporal.workflow.ChildWorkflowOptions;
import io.temporal.workflow.Workflow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
@WorkflowImpl(taskQueues = "DEPLOYMENT_QUEUE_V1")
public class SoftwareReleaseWorkflowImpl implements SoftwareReleaseWorkflow {

    private Deployment deploymentResponse;

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(100))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(50000).build();

    // Child workflow options for Deployments
    private final ChildWorkflowOptions.Builder deploymentWFOptionBuilder = ChildWorkflowOptions.newBuilder()
            .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE_FAILED_ONLY)
            .setTaskQueue("DEPLOYMENT_QUEUE_V1");

    @Override
    public SoftwareRelease startSoftwareReleaseWorkflow(Artifact art, String workflowId) {

        Artifact artifact = Artifact.getDefaultInstance();
        SoftwareRelease softwareRelease = SoftwareRelease.newBuilder()
                .setId(workflowId)
                .setArtifactId(art.getId())
                .build();

        String childWFId = "ryug3yb3g3h8";

        var opts = deploymentWFOptionBuilder.setWorkflowId(childWFId).build();
        var deploymentWorkflowResp = Workflow.newChildWorkflowStub(DeploymentWorkflow.class, opts);

        Async.procedure(deploymentWorkflowResp::startDeployment, softwareRelease, artifact, workflowId);

        return softwareRelease;
    }


}