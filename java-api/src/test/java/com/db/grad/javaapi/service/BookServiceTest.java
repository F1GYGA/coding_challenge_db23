package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


    @BeforeAll
    void setUp() {
        Book book = new Book();
        book.setBookName("trading_book_7");

        Set<Book> setBook = new HashSet<>();
        setBook.add(book);

        User user = new User();
        user.setUserName("Michael");
        user.setPassword("michael");
        user.setUserBooks(setBook);

        Set<User> setUser = new HashSet<>();
        setUser.add(user);
        book.setBookUsers(setUser);

        bookRepository.save(book);
        userRepository.save(user);
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