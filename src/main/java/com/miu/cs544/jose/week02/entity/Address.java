package com.miu.cs544.jose.week02.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.Null;

@Embeddable
public class Address {
    private String number;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address() {
    }

    public Address(String number, String street, String city, String state, int zipCode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address: ");
        sb.append(number);
        sb.append(" ").append(street);
        sb.append(", ").append(city);
        sb.append(", ").append(state);
        sb.append(" ").append(zipCode);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getZipCode() != address.getZipCode()) return false;
        if (!getNumber().equals(address.getNumber())) return false;
        if (!getStreet().equals(address.getStreet())) return false;
        if (!getCity().equals(address.getCity())) return false;
        return getState().equals(address.getState());
    }

    @Override
    public int hashCode() {
        int result = getNumber().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getZipCode();
        return result;
    }
}
