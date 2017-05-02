package com.jw.grpc.test.client;

import java.io.FileNotFoundException;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import shj.bsp.core.utils.yaml.ConfigManager;
import shj.bsp.log.util.Log4jUtil;

public class ClientMain{
	public static void main(String[] args){
		/*try{
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}*/
		if(!initLogger()) return;
		Log4jUtil.setVariable("pid", Log4jUtil.getPID());
		
		ApplicationContext context= new ClassPathXmlApplicationContext("config/spring/spring.xml");
		try{
//			context.getBean(TestClient.class).sendMessage("asdf", 89);
			context.getBean(TestClient.class).sayHello();
		}catch(BeansException e){
			e.printStackTrace();
		}
	}
	
	public static boolean initLogger(){
		return new ConfigManager(){

			@Override
			public String getYamlPath(){
				return "/config/application.yml";
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean buildConfigs(Map<String, Object> configs){
				try{
					if(!configs.containsKey("app")){
						System.out.println("application.yml not has app define!!!");
						return false;
					}
					Map<String, Object> app = (Map<String, Object>)configs.get("app");
					String appName = (String)app.get("name");
					String appVersion = (String)app.get("version");
					if(null == appName || null == appVersion) return false;
					Log4jUtil.setVariable("appName", appName);
					Log4jUtil.setVariable("appVersion", appVersion);
				}catch(Exception e){
					System.out.println("load yaml config error when init logger!!!!");
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}.parse();
	}
}
