package com.example.RESTfulService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    private UserList userList;

    @GetMapping("/")
    public List<User> getUsers() {
        return userList.getUsers();
    }
}
