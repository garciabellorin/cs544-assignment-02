package com.miu.cs544.jose.week02.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String dob;
    @ManyToMany(mappedBy = "owners", cascade = CascadeType.ALL)
    private List<Car> carsOwned = new ArrayList<>();

    public Person() {
    }

    public Person(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void addCarOwner(Car car) {
        this.carsOwned.add(car);
        car.addOwner(this);
    }

    public void removeCarOwner(Car car) {
        this.carsOwned.remove(car);
        car.removeOwner(this);
    }

    public List<Car> getCarsOwned() {
        return Collections.unmodifiableList(carsOwned);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dob='").append(dob).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!getId().equals(person.getId())) return false;
        if (!getName().equals(person.getName())) return false;
        if (!getDob().equals(person.getDob())) return false;
        return carsOwned.equals(person.carsOwned);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDob().hashCode();
        result = 31 * result + carsOwned.hashCode();
        return result;
    }
}