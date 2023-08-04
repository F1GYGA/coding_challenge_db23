package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.BookDto;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        List<BookDto> list = new ArrayList<>();

        for (Book book : bookService.getAllBooks()) {
            list.add(new BookDto(book.getId(), book.getBookName()));
        }

        return list;
    }
}
