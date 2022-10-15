package com.appkodar.courses.springwebfluxrouterfunctiondemo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * created by Satheesh Raju on 15-10-2022
 */
@Data
public class User {
    private long id;
    private String name;


    public User(long id) {
        this.id = id;
        this.name = "User : " + id;
    }
}
