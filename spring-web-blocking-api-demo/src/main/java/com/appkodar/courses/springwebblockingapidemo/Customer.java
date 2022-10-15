package com.appkodar.courses.springwebblockingapidemo;

import lombok.Data;

/**
 * created by Satheesh Raju on 15-10-2022
 */
@Data
public class Customer {

    private long id;
    private String name;

    public Customer(long id) {
        this.id = id;
        this.name = "Customer : " + id;
    }
}
