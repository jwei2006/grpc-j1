package com.jw.grpc.test.client;

import org.springframework.stereotype.Service;

import com.jw.test.grpc.e.proto.HelloReply;
import com.jw.test.grpc.e.proto.HelloRequest;
import com.jw.test.grpc.e.proto.SimpleGrpc;
import com.test.grpc.service.TestRpcServiceGrpc;
import com.test.grpc.service.TestRpcServiceGrpc.TestRpcServiceBlockingStub;
import com.test.grpc.service.model.TestModel;

import io.grpc.Channel;
import shj.grpc.client.GrpcClient;

@Service
public class TestClient{
	@GrpcClient("e-grpc-server")
	private Channel serverChannel;

	public String sendMessage(String name, Integer id){
		TestRpcServiceBlockingStub stub = TestRpcServiceGrpc.newBlockingStub(serverChannel);
		TestModel.TestRequest request = TestModel.TestRequest.newBuilder().setId(id).setName(name).build();
		TestModel.TestResponse response = stub.sayHello(request);
		System.out.println(response.getMessage());
		return response.getMessage();
	}
	
	public String sayHello(){
		SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
		HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName("grpc-e-client").build());
		System.out.println(response.getMessage());
		return response.getMessage();
	}
}
