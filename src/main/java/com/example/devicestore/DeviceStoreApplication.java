package com.example.devicestore;

import com.example.devicestore.test1.ExampleHelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DeviceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceStoreApplication.class, args);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("testconfig.xml");
		ExampleHelloWorld exampleHelloWorld = applicationContext.getBean("exampleHelloWorld", ExampleHelloWorld.class);
		System.out.println(exampleHelloWorld.getText());

	}

}
