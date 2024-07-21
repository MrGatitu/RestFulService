package com.example.RESTfulService;

public class User {
    int id;
    String name;
    String email;

    public User (int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    

    @Override
    public String toString(){
        return String.format(
            "User[id ='%d', name = '%s', email = 's']",
            id, name, email
        );
    }
}
