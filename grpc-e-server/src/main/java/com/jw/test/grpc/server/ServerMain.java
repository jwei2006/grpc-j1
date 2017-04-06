package com.jw.test.grpc.server;

/*import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import io.grpc.Server;
import shj.grpc.server.NettyGrpcServerFactory;*/
import shj.grpc.server.manager.ServerManager;

public class ServerMain{
	public static void main(String[] args){
		// PropertyConfigurator.configure("config/log4j.xml");
		// ConfigurationSource
		/*try{
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/spring.xml");
		try{
			Server server = context.getBean("nettyGrpcServerFactory", NettyGrpcServerFactory.class).createServer().start();
			if(server != null) server.awaitTermination();
		}catch(BeansException | IOException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			if(null != context) ((ClassPathXmlApplicationContext)context).close();
		}*/
//		ServerManager.startServer(null, "config/spring/spring.xml");
		ServerManager.startServer();
	}
}
