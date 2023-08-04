package com.db.grad.javaapi.dto;

import lombok.Data;

import java.util.List;


@Data
public class BookDto {
    private long id;
    private String bookName;
    private List<BondDto> bonds;

    public BookDto(long id, String bookName,List<BondDto> bonds) {
        this.id = id;
        this.bookName = bookName;
        this.bonds = bonds;
    }
}
