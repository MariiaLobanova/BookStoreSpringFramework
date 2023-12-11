package com.example.bookStore;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "myapp.books")
public class Book {

    @Value("${myapp.books.id}")
    private int id;
    @Value("${myapp.books.title}")
    private String title;

    @Value("${myapp.books.author}")
    private String author;

    @Nonnull
    @Value("${myapp.books.price}")
    private double price;
    private int quantity;
    private int authorId;

    public Book(int id, String title, String author, double price, int quantity, int authorId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.authorId = authorId;
    }

    public Book(){}

    public Book(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @PostConstruct
    public void init(){
        System.out.println("Book bean is being initialized.");

        System.out.println("Message from application.property BookId is: " + id+" ;Title: "+title+" ;Author: "+ author+" ;Price: "+ price );
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Book bean is being destoyed.");
    }
}
