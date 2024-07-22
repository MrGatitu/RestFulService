package com.example.RESTfulService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    private final UserList userList;

    @Autowired
    public UsersController(UserList userList) {
        this.userList = userList;
    }

    @GetMapping(path ="/all",produces = "application/json")
    public List<User> getUsers() {
        return userList.getUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<Object> adduserEntity(@RequestBody User user){
        userList.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}