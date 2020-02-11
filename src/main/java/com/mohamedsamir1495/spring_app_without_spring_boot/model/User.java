package com.mohamedsamir1495.spring_app_without_spring_boot.model;


import lombok.Data;

import java.util.ArrayList;

@Data
public class User {

    private String email;
    private String name;
    private ArrayList<String> subscribedTopics;

    public User(String email, String name, ArrayList<String> subscribedTopics) {
        this.email = email;
        this.name = name;
        this.subscribedTopics = subscribedTopics;
    }
}
