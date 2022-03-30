package com.miu.cs544.jose.week02.entity;

import javax.persistence.Entity;

@Entity
public class Driver extends Person{
    public Driver() {
    }

    public Driver(String name, String dob) {
        super(name, dob);
    }
}
