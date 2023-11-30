package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.Address;
import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.entity.Store;
import ru.javarush.lukyanov.hibernate2.repository.CustomerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerService {
    private Customer customer;
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        customerRepository = CustomerRepository.getCustomerRepository();
        return customerRepository.save(customer);
    }

}
