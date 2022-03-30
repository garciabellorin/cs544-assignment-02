package com.miu.cs544.jose.week02.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver extends Person{

    @ManyToMany(mappedBy = "drivers")
    private List<Car> cars = new ArrayList<>();

    public Driver() {
    }

    public Driver(String name, String dob) {
        super(name, dob);
    }

    public void setCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
    }
}
