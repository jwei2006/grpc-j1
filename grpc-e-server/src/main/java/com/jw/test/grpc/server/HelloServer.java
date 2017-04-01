package com.jw.test.grpc.server;

import com.jw.test.grpc.e.proto.HelloReply;
import com.jw.test.grpc.e.proto.SimpleGrpc;

import shj.grpc.server.GrpcService;

@GrpcService(SimpleGrpc.class)
public class HelloServer extends SimpleGrpc.SimpleImplBase{
	public void sayHello(com.jw.test.grpc.e.proto.HelloRequest request,
	        io.grpc.stub.StreamObserver<com.jw.test.grpc.e.proto.HelloReply> responseObserver) {
		System.out.println(request.getName());
		HelloReply reply = HelloReply.newBuilder().setMessage("server message: HelloServer").build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}
