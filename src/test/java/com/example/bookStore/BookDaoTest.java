package com.example.bookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookDaoTest {

    @Test
    public void testBookDaoClass() throws Exception {
        Connection connection = DBConnection.getConnection();
        connection.setAutoCommit(false);

        BookDao bookDao = new BookDao(new DBConnection(connection));

        try {
            bookDao.createBook(new Book(1, "title", "author", 9.99, 5, 2));
            bookDao.createBook(new Book(2, "title2", "author2", 19.99, 5, 3));

            Book book1 = bookDao.getBookById(1);
            Book book2 = bookDao.getBookById(2);

            assertEquals("title", book1.getTitle());
            assertEquals("author", book1.getAuthor());
            assertEquals(9.99, book1.getPrice(), 0.001);
            assertEquals(5, book1.getQuantity());
            assertEquals(2, book1.getAuthorId());

            assertEquals("title2", book2.getTitle());
            assertEquals("author2", book2.getAuthor());
            assertEquals(19.99, book2.getPrice(), 0.001);
            assertEquals(5, book2.getQuantity());
            assertEquals(3, book2.getAuthorId());

            bookDao.updateBook(new Book(1, "title", "author", 29.99, 7, 2));
            bookDao.updateBook(new Book(2, "title2", "author2", 29.99, 7, 3));

            Book updatedBook1 = bookDao.getBookById(1);
            Book updatedBook2 = bookDao.getBookById(2);

            assertEquals(29.99, updatedBook1.getPrice(), 0.001);
            assertEquals(7, updatedBook1.getQuantity());

            assertEquals(29.99, updatedBook2.getPrice(), 0.001);
            assertEquals(7, updatedBook2.getQuantity());

            Book removeBook1 = bookDao.getBookById(1);
            Book removeBook2 = bookDao.getBookById(2);

            assertNull(removeBook1);
            assertNull(removeBook2);

        } finally {
            connection.rollback();
            connection.close();
        }
    }
}