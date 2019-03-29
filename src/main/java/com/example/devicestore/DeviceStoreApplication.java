package com.example.devicestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.devicestore")
@SpringBootApplication
public class DeviceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceStoreApplication.class, args);
	}

}
