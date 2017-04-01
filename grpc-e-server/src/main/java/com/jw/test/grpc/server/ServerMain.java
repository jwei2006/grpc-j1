package com.jw.test.grpc.server;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.grpc.Server;
import shj.grpc.server.NettyGrpcServerFactory;

public class ServerMain{
	public static void main(String[] args){
		ApplicationContext context= new ClassPathXmlApplicationContext("config/spring/spring.xml");
		try{
			Server server = context.getBean("nettyGrpcServerFactory", NettyGrpcServerFactory.class).createServer().start();
			if (server != null)
		        server.awaitTermination();
		}catch(BeansException | IOException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
