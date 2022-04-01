package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CAR_DRIVERS",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id")
    )
    private List<Driver> driver = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CAR_OWNERS",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<Owner> owners = new ArrayList<>();

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

    public List<Owner> getOwners() {
        return Collections.unmodifiableList(owners);
    }

    public void setOwner(Owner owner) {
        if (owner != null && owners.size() < 2)
            this.owners.add(owner);
    }


    public void setDriver(Driver driver) {
        this.driver.add(driver);
    }

    private List<Driver> getDriver() {
        return new ArrayList<>(this.driver);
    }

}
