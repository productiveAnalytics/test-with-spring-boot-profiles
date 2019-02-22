package com.productiveAnalytics.springBoot.spring;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.productiveAnalytics.springBoot.di.Node;

@SpringBootApplication
@ComponentScan(basePackages = "com.productiveAnalytics.springBoot")
public class MyApplication 
			 implements CommandLineRunner, InitializingBean
{
	@Autowired
	private Node node;
	
	public static void main(String[] args) {
		ApplicationContext appCtx = SpringApplication.run(MyApplication.class, args);
		
		int beanIndex=0;
		for (String beanName : appCtx.getBeanDefinitionNames()) {
			System.out.println(String.format("Bean[%d] = %s", beanIndex, beanName));
		}
	}

	@Override
	public void run(String... args) throws Exception {
		String request;
		
		if (args.length < 1) {
			System.err.println("Incorrect invocation...");
			System.err.println("   Usage: MyApplication cityName");
			
			request = "Mumbai";
			System.err.println("   Using default city: "+ request);
		}
		else {
			request = args[0];
		}
		
		String response = node.process(request);
		System.out.println("MyApplication Response "+ response);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (node == null) {
			System.err.println("Node could not be autowired...exiting");
			throw new BeanInitializationException("Node filed is not autowired correctly...");
		}
	}

}
