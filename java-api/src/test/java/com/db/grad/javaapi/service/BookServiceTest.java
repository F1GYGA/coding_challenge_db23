package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    private Book book;



    @BeforeAll
    void setUp() {
        this.book = new Book();
        book.setBookName("trading_book_7");

        Set<Book> set = new HashSet<>();
        set.add(book);

        User user = new User();
        user.setUserName("Michael");
        user.setPassword("michael");
        user.setUserBooks(set);

        userRepository.save(user);
        bookRepository.save(book);

    }

    @Test
    void getAllBooks() {
        int booksCount = bookRepository.findAll().size();
        assertThat(bookService.getAllBooks().size()).isEqualTo(booksCount);
    }

    @Test
    void getUserBooks() {
        List<Book> userbooks = bookService.getUserBooks("Michael");
        assertEquals(1, userbooks.size());
    }

}