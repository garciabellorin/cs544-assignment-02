package com.miu.cs544.jose.week02.entity;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class Company {

    private String name;
    @Embedded
    private Address address;

    public Company() {
    }

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!getName().equals(company.getName())) return false;
        return getAddress().equals(company.getAddress());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company: ");
        sb.append(name).append("\n");
        sb.append(address);
        return sb.toString();
    }
}
