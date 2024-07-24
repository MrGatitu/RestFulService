package com.example.RESTfulService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserList {

    private static List<User> users = new ArrayList<>();

    User user;

    static {

        users.add(new User(1, "Vivian", "123@example.com"));
        users.add(new User(2, "Barry", "mail@example.com"));
        users.add(new User(3, "Rajesh", "rajesh@email.com"));
    }

    public static List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public static void _getMethod(int _id){
        users.get(_id);

        System.out.println(users.get(_id));
        
    }

    public void addUser(User user) {
        this.user = user;

        if (user == null){
            users.add(user);
        }        
    }

    public static void main(String[] args) {
        UserList _getUser;

        try {
            System.out.println(_getMethod(0));
            //addUser(4,"Ian", "123@email.com");
        } catch (Exception e) {
            System.out.println("Error");
        }


        
    }

}
