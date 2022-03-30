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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        InsuranceCompany that = (InsuranceCompany) o;

        if (getRating() != that.getRating()) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getRating();
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InsuranceCompany{");
        sb.append("id=").append(id);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}