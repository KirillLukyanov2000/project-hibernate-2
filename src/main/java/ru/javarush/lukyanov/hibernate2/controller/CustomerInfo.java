package ru.javarush.lukyanov.hibernate2.controller;


import ru.javarush.lukyanov.hibernate2.entity.Address;
import ru.javarush.lukyanov.hibernate2.entity.Store;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerInfo {
    public Short customerId;

    public Byte storeId;

    public String firstName;

    public String lastName;

    public String email;

    public Short addressId;

    public Byte active;

    public LocalDate createDate;

    public LocalDateTime lastUpdate;
    public Store store;

    public Address address;
}
