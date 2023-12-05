package com.example.bookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

@Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping
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
}
