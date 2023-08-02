package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

        @Autowired
        private BookRepository bookRepo;

}
