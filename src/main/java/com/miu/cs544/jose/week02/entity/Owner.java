package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Person {

    @ManyToMany(mappedBy = "owners")
    private Set<Car> cars = new HashSet<>();

    public Owner() {
    }

    public Owner(String name, String dob) {
        super(name, dob);
    }

    public boolean addCar(Car car) {
        return this.addCar(car);
    }

    public boolean removeCar(Car car) {
        return cars.remove(car);
    }
}
