package com.example.bookStore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {

        this.bookDao = bookDao;
    }

    @GetMapping
    public Book getBook(@RequestBody Book book){
        bookDao.createBook(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable int id) {
        bookDao.removeBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        bookDao.updateBook(book);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBookById(@PathVariable("id") int id) {
        return bookDao.getBookById(id);
    }

    @PostConstruct
    public void init(){
        System.out.println("BookController bean is being initialized.");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("BookController bean is destoyed.");
    }

}
