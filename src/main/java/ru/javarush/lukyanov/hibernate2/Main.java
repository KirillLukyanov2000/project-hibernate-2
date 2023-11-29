package ru.javarush.lukyanov.hibernate2;


import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.service.CustomerService;

public class Main {
    private static CustomerService customerService;

    public static void main(String[] args) {
        customerService.createCustomer();

    }
}
