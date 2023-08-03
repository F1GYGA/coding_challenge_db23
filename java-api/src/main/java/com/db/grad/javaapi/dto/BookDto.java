package com.db.grad.javaapi.dto;

import lombok.Data;


@Data
public class BookDto {
    private long id;
    private String bookName;

    public BookDto(long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }
}
