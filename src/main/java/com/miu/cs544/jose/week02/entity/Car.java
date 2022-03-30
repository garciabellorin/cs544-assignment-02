package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private int year;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private CarManufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_company_id", nullable = true)
    private InsuranceCompany insuranceCompany;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_1")
    private Owner owner1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_2")
    private Owner owner2;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CAR_DRIVERS",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id")
    )
    private List<Driver> drivers = new ArrayList<>();

    public void setDriver(Driver driver) {
        this.drivers.add(driver);
    }

    private List<Driver> getDrivers() {
        return new ArrayList<>(this.drivers);
    }

    public Car() {
    }

    public Car(CarManufacturer manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }


    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CarManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CarManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Owner getOwner1() {
        return owner1;
    }

    public void setOwner1(Owner owner1) {
        this.owner1 = owner1;
    }

    public Owner getOwner2() {
        return owner2;
    }
//
    public void setOwner2(Owner owner2) {
        this.owner2 = owner2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (!getId().equals(car.getId())) return false;
        if (!getModel().equals(car.getModel())) return false;
        return manufacturer.equals(car.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + year;
        result = 31 * result + manufacturer.hashCode();
        return result;
    }
}
