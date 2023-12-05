package com.example.bookStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.bookStore")
public class AppConfig {
    @Bean
    public Book book() {

        return new Book();
    }

    @Bean
    public BookDao bookDao() {

        return new BookDao();
    }

    @Bean
    public BookController bookController() {

        return new BookController(bookDao());
    }
}
