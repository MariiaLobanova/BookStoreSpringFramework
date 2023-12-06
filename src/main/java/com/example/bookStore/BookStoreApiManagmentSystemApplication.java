package com.example.bookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


	@SpringBootApplication(scanBasePackages = "com.example.bookStore")
	public class BookStoreApiManagmentSystemApplication {
		public static void main(String[] args) {
			SpringApplication.run(BookStoreApiManagmentSystemApplication.class, args);
		}
	}

