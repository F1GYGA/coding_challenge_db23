package com.db.grad.javaapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
@Data
public class UserDto implements Comparable<UserDto> {
    private long id;
    private String userName;

    public UserDto(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public int compareTo(UserDto o) {
        if (o.getId() == this.getId() && Objects.equals(o.getUserName(), this.getUserName()))
            return 0;

        return -1;
    }
}
