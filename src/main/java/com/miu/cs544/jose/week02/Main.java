package com.miu.cs544.jose.week02;

import com.miu.cs544.jose.week02.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Create Persons in DB
        Person james = new Person("James", "01/01/2000");
        Person robert = new Person("Robert", "02/02/2002");
        Person mary = new Person("Mary", "09/09/1999");
        Person linda = new Person("Linda", "08/08/1988");
        Person susan = new Person("Susan", "07/07/1997");

        // Create Addresses and Companies
        Address fordAddress = new Address("One", "American Rd", "Dearborn", "MI", 48126);
        Address nissanAddress = new Address("1", "Nissan Way", "Franklin", "TN", 37067);
        Address generalMotorsAddress = new Address("300", "Renaissance Ctr", "Detroit", "MI", 48243);
        Address stateFarmAddress = new Address("One", "State Farm Plaza", "Bloomington", "IL", 61710);
        Address geicoAddress = new Address("500 SW", "39th St", "Renton", "WA", 98057);

        CarManufacturer ford = new CarManufacturer("Ford", fordAddress, 186_000, 1903);
        CarManufacturer nissan = new CarManufacturer("Nissan", nissanAddress, 21_000, 1933);
        CarManufacturer generalMotors = new CarManufacturer("General Motors", generalMotorsAddress, 85_000, 1908);

        InsuranceCompany geico = new InsuranceCompany("GEICO", 5, geicoAddress);
        InsuranceCompany stateFarm = new InsuranceCompany("State Farm", 4, stateFarmAddress);

        Car fusion = new Car("Fusion", "SEL", 2021);
        Car sentra = new Car("Sentra", "S", 2019);
        Car mustang = new Car("Mustang", "GT", 2022);

        james.addCarOwner(mustang);
        robert.addCarOwner(mustang);
//        Mary should be 3rd owner but is limited to two.
        mary.addCarOwner(mustang);

        fusion.setInsuranceCompany(stateFarm);
        sentra.setInsuranceCompany(stateFarm);
        mustang.setInsuranceCompany(geico);


        tx.begin();
        em.persist(james);
        em.persist(robert);
        em.persist(mary);
        em.persist(linda);
        em.persist(susan);
        em.persist(ford);
        em.persist(nissan);
        em.persist(generalMotors);
        em.persist(geico);
        em.persist(stateFarm);
        em.persist(fusion);
        em.persist(sentra);
        em.persist(mustang);
        tx.commit();
        em.close();
        emf.close();

    }
}
