package com.example.RESTfulService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    
    private final UserList userList;

    @Autowired
    public UsersController(UserList userList) {
        this.userList = userList;
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userList.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> _getUser(@PathVariable ("id") int id) {
        try {
            String specificUser = userList._getMethod(id);
            return new ResponseEntity<>(specificUser, HttpStatus.OK);
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    
//     @GetMapping("/hello")
//     ResponseEntity<String> hello() {
//     return ResponseEntity.ok("Hello World!");
// }
    @PostMapping("/add")
    public ResponseEntity<Object> adduserEntity(@RequestBody User user){
        userList.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}