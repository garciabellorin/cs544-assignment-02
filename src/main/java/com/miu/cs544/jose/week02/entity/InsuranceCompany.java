package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InsuranceCompany extends Company implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private int rating;
    @OneToMany(mappedBy = "insuranceCompany")
    private Set<Car> cars = new HashSet<>();

    public InsuranceCompany() {
    }

    public InsuranceCompany(String name, int rating, Address address) {
        super(name, address);
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }

    public boolean addCar(Car car){
        car.setInsuranceCompany(this);
        return this.addCar(car);
    }

    public boolean removeCar(Car car){
        car.setInsuranceCompany(null);
        return this.removeCar(car);
    }
}