package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CarManufacturer that = (CarManufacturer) o;

        if (getNumberOfEmployees() != that.getNumberOfEmployees()) return false;
        if (getYearEstablished() != that.getYearEstablished()) return false;
        if (!id.equals(that.id)) return false;
        return cars.equals(that.cars);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + getNumberOfEmployees();
        result = 31 * result + getYearEstablished();
        result = 31 * result + cars.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarManufacturer{");
        sb.append("id=").append(id);
        sb.append(", numberOfEmployees=").append(numberOfEmployees);
        sb.append(", yearEstablished=").append(yearEstablished);
        sb.append(", cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}