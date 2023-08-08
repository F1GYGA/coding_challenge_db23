package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    void setUp() {
        User user = new User();
        user.setUserName("vlados");
        user.setPassword("bob");
        User user2 = new User();
        user2.setUserName("danu");
        user2.setPassword("bob");

        userRepository.saveAll(Arrays.asList(user, user2));
    }

    @Test
    void getAllUsers() {
        int usersCount = userRepository.findAll().size();
        assertThat(userService.getAllUsers().size()).isEqualTo(usersCount);
    }
}