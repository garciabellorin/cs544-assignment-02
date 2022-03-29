package com.miu.cs544.jose.week02.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private int year;
    private String trim;
    @OneToOne
    @JoinColumn(name = "insurance_company_id", referencedColumnName = "id")
    private InsuranceCompany insuranceCompany;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "car_owners",
            joinColumns = {@JoinColumn(name = "fk_car")},
            inverseJoinColumns = {@JoinColumn(name = "fk_owner")})
    private List<Person> owners = new ArrayList<>();


    public Car(String model, String trim, int year) {
        this.model = model;
        this.trim = trim;
        this.year = year;
    }

    public Car() {
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

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public List<Person> getOwners() {
        return Collections.unmodifiableList(owners);
    }

    public void addOwner(Person owner) {
        if (owners.size() < 2) {
            owners.add(owner);
        }
    }

    public void removeOwner(Person owner) {
        owners.remove(owner);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", insuranceCompany=").append(insuranceCompany);
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
        if (!trim.equals(car.trim)) return false;
        if (getInsuranceCompany() != null ? !getInsuranceCompany().equals(car.getInsuranceCompany()) : car.getInsuranceCompany() != null)
            return false;
        return getOwners().equals(car.getOwners());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + year;
        result = 31 * result + trim.hashCode();
        result = 31 * result + (getInsuranceCompany() != null ? getInsuranceCompany().hashCode() : 0);
        result = 31 * result + getOwners().hashCode();
        return result;
    }
}
