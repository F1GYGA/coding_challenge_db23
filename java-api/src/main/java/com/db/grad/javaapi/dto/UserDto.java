package com.db.grad.javaapi.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String userName;

    public UserDto(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
