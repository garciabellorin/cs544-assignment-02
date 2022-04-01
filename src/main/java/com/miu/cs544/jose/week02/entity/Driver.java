package com.miu.cs544.jose.week02.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Driver extends Person{

    @ManyToMany(mappedBy = "driver")
    private Set<Car> cars = new HashSet<>();

    public Driver() {
    }

    public Driver(String name, String dob) {
        super(name, dob);
    }

    public void setCar(Car car) {
        this.cars.add(car);
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }
}
