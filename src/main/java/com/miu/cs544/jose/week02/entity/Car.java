package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private int year;
    @JoinColumn(name = "manufacturer_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private CarManufacturer manufacturer;

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

    public CarManufacturer getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(CarManufacturer manufacturer){
        this.manufacturer = manufacturer;
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
