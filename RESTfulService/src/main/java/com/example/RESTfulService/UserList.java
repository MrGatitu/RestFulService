package com.example.RESTfulService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserList {

    private static List<User> users = new ArrayList<>();

    static {

        users.add(new User(1, "Vivian", "123@example.com"));
        users.add(new User(2, "Barry", "mail@example.com"));
        users.add(new User(3, "Rajesh", "rajesh@email.com"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    /*public static void main(String[] args) {

        try {
            System.out.println(getUsers());
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }*/
}
