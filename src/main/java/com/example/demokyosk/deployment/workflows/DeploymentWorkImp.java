package com.example.demokyosk.deployment.workflows;//package app.example.example.deployment.deployment.temporal.workflows;

import deployment.asset.v1.QueryOperator;
import deployment.deployment.v1.Deployment;
import deployment.asset.v1.QueryRequest;
import deployment.asset.v1.Filter;
import deployment.asset.v1.AssetServiceGrpc;
import deployment.software_release.v1.SoftwareRelease;
import deployment.artifact.v1.Artifact;
import io.temporal.spring.boot.WorkflowImpl;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;

/**
 * @author muchembi
 * @date 08/07/2024
 * https://github.com/muchembi
 */
@SuppressWarnings("checkstyle:WhitespaceAround")
@WorkflowImpl(taskQueues = "DEPLOYMENT_QUEUE_V1") // It is a placeholder method to enable testing.
@RequiredArgsConstructor
public class DeploymentWorkImp implements DeploymentWorkflow {


    @GrpcClient("config_service")
    private AssetServiceGrpc.AssetServiceBlockingStub stub;

    /**
     * @param dw
     * @param art
     * @return
     */
    @Override
    public Deployment startDeployment(SoftwareRelease dw, Artifact art, String workflowId) {
        stub.queryAsset(QueryRequest
                .newBuilder().addFilters(Filter.newBuilder()
                        .setField("id")
                        .setOp(QueryOperator.EQ)
                        .setValue("0GTWPDQSK946N")
                        .build())
                .build());
        return null;
    }

}
