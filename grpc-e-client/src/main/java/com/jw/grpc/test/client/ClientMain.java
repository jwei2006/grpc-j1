package com.jw.grpc.test.client;

import java.io.FileNotFoundException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class ClientMain{
	public static void main(String[] args){
		try{
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}
		ApplicationContext context= new ClassPathXmlApplicationContext("config/spring/spring.xml");
		try{
//			context.getBean(TestClient.class).sendMessage("asdf", 89);
			context.getBean(TestClient.class).sayHello();
		}catch(BeansException e){
			e.printStackTrace();
		}
	}
}
