package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.UserDto;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<UserDto> list = new ArrayList<>();

        for (User user : userService.getAllUsers())
            list.add(new UserDto(user.getId(), user.getUserName()));

        return list;
    }
}
