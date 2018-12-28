package com.quicklearn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.quicklearn.persistence"})
@EntityScan(basePackages = {"com.quicklearn.domain"})
//@ComponentScan(basePackages = {"com.quicklearn.persistence","com.quicklearn.domain"})
@ComponentScan({"com.quicklearn.persistence","com.quicklearn.domain","com.quicklearn.web"})
public class RestApiApplication {

	public static void main(String [] args) {
		//SpringApplication.run(RestApiApplication.class, args);
		ApplicationContext applicationContext = 
				SpringApplication.run(RestApiApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}
