package com.jw.grpc.test.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMain{
	public static void main(String[] args){
		ApplicationContext context= new ClassPathXmlApplicationContext("config/spring/spring.xml");
		try{
//			context.getBean(TestClient.class).sendMessage("asdf", 89);
			context.getBean(TestClient.class).sayHello();
		}catch(BeansException e){
			e.printStackTrace();
		}
	}
}
