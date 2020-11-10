package com.hemlata.app;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hemlata.app.config.SecurityConfiguration;

@SpringBootApplication

public class StudentAssignmentManagmentSystemApplication {


	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext container=new AnnotationConfigApplicationContext(SecurityConfiguration.class);
		SpringApplication.run(StudentAssignmentManagmentSystemApplication.class, args);
	}

}
