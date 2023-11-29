package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.Customer;

public class CustomerService {
    private Customer customer;
    private DBService<Customer> dbService;

    public void createCustomer() {
        customer = new Customer();
        dbService = new DBService<>(Customer.class);
        dbService.create(customer);
    }

}
