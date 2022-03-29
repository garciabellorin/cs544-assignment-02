package com.miu.cs544.jose.week02.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class CarManufacturer extends Company implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private int numberOfEmployees;
    private int yearEstablished;

    public CarManufacturer(int numberOfEmployees, int yearEstablished) {
        this.numberOfEmployees = numberOfEmployees;
        this.yearEstablished = yearEstablished;
    }

    public CarManufacturer(String name, Address address, int numberOfEmployees, int yearEstablished) {
        super(name, address);
//        this.id = id;
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
}
