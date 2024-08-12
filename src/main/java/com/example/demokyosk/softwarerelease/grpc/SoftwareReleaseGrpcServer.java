package com.example.demokyosk.softwarerelease.grpc;//package app.example.example.deployment.softwarerelease.grpc;
//
//import app.kyosk.common.entity_id.v1.EntityId;
//import app.kyosk.common.query.v1.QueryRequest;
//import app.kyosk.deployment.software_release.v1.QuerySoftwareReleaseResponse;
//import app.kyosk.deployment.software_release.v1.SoftwareReleaseServiceGrpc;
//import app.kyosk.google.rpc.Code;
//import app.kyosk.idp.common.util.grpc.GrpcUtil;
//import app.kyosk.idp.deployment.deployment.service.DeploymentService;
//import app.kyosk.idp.deployment.softwarerelease.service.SoftwareReleaseService;
//import app.kyosk.rpc.status.v1.Status;
//import io.grpc.stub.StreamObserver;
//import lombok.RequiredArgsConstructor;
//import net.devh.boot.grpc.server.service.GrpcService;
//
///**
// * @author Lewis
// * <p>
// * Date: 7/10/2024
// * Time: 9:20 AM
// * <p>
// */
//@GrpcService
//@RequiredArgsConstructor
//public class SoftwareReleaseGrpcServer extends SoftwareReleaseServiceGrpc.SoftwareReleaseServiceImplBase {
//    private final SoftwareReleaseService softwareReleaseService;
//
//    private final DeploymentService deploymentService;
//
//    @Override
//    public void querySoftwareRelease(QueryRequest request,
//                                       StreamObserver<QuerySoftwareReleaseResponse> responseObserver) {
//        GrpcUtil.wrapRequest(
//                request,
//                softwareReleaseService::querySoftwareRelease,
//                deployments -> QuerySoftwareReleaseResponse.newBuilder().addAllSoftwareRelease(deployments).build(),
//                responseObserver);
//    }
//
//    @Override
//    public void deployToProd(EntityId request, StreamObserver<Status> responseObserver) {
//
//        GrpcUtil.wrapRequest(
//                request,
//                deploymentService::initiateDeployment,
//                deployments -> Status.newBuilder().setCode(Code.OK).setMessage("Deployment started").build(),
//                responseObserver);
//
//    }
//}
