package com.miu.cs544.jose.week02.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Person {

    @OneToMany
    private Set<Car> cars = new HashSet<>();

    public Owner() {
    }

    public Owner(String name, String dob) {
        super(name, dob);
    }

    public boolean addCar(Car car){
        return cars.add(car);
    }

    public boolean removeCar(Car car){
        return cars.remove(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Owner owner = (Owner) o;

        return cars != null ? cars.equals(owner.cars) : owner.cars == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}
