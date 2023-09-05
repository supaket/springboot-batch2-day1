package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
			//app.setBannerMode(Banner.Mode.OFF);
		ConfigurableApplicationContext context  = app.run(args);

		AppConfiguration bean = context.getBean(AppConfiguration.class);
		System.out.println(bean.getUsers());
	}
}
