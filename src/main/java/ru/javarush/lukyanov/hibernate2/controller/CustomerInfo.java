package ru.javarush.lukyanov.hibernate2.controller;


import ru.javarush.lukyanov.hibernate2.entity.Address;
import ru.javarush.lukyanov.hibernate2.entity.Store;


import java.time.LocalDateTime;

public class CustomerInfo {
    public Short customerId;

    public Store store;
    public String firstName;

    public String lastName;

    public String email;

    public Address address;

    public Boolean isActive;

    public LocalDateTime createDate;


    public LocalDateTime lastUpdate;


}
