package ru.javarush.lukyanov.hibernate2.controller;

import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.service.CustomerService;

import static java.util.Objects.isNull;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private static CustomerInfo toCustomerInfo(Customer customer) {
        if (isNull(customer)) return null;

        CustomerInfo result = new CustomerInfo();
        result.customerId = customer.getCustomerId();
        result.store = customer.getStore();
        result.firstName = customer.getFirstName();
        result.lastName = customer.getLastName();
        result.email = customer.getEmail();
        result.address = customer.getAddress();
        result.isActive = customer.getActive();
        result.createDate = customer.getCreateDate();
        result.lastUpdate = customer.getLastUpdate();

        return result;
    }
}
