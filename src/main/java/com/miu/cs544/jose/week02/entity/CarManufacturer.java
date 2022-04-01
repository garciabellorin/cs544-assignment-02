package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CarManufacturer extends Company implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private int numberOfEmployees;
    private int yearEstablished;
    @OneToMany(mappedBy = "manufacturer", targetEntity = Car.class)
    private Set<Car> cars = new HashSet<>();

    public CarManufacturer(int numberOfEmployees, int yearEstablished) {
        this.numberOfEmployees = numberOfEmployees;
        this.yearEstablished = yearEstablished;
    }

    public CarManufacturer(String name, Address address, int numberOfEmployees, int yearEstablished) {
        super(name, address);
        this.numberOfEmployees = numberOfEmployees;
        this.yearEstablished = yearEstablished;
    }

    public CarManufacturer() {

    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public Set<Car> getCars(){
        return Collections.unmodifiableSet(cars);
    }

    public boolean addCar(Car car){
        car.setManufacturer(this);
        return this.addCar(car);
    }

    public boolean removeCar(Car car){
        car.setManufacturer(null);
        return this.removeCar(car);
    }
}