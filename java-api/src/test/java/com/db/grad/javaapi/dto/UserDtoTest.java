package com.db.grad.javaapi.dto;

import com.db.grad.javaapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserDtoTest {

    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto(1, "John");
    }

    @Test
    @DisplayName("Match users")
    void compareTo() {
        UserDto input = new UserDto(1, "John");
        assertEquals(userDto, input);
    }

}