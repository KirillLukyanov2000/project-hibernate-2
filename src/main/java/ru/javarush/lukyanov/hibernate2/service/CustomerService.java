package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.*;
import ru.javarush.lukyanov.hibernate2.repository.ActorRepository;
import ru.javarush.lukyanov.hibernate2.repository.CustomerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class CustomerService {
    private Customer customer;
    private CustomerRepository customerRepository;
    private RepositoryProvider repositoryProvider;

    public Customer createNewRandomCustomer() {
        repositoryProvider = new RepositoryProvider();
        customerRepository = repositoryProvider.getCustomerRepository();
        Store store = repositoryProvider.getStoreRepository().getItems(0, 1).get(0);
        City city = repositoryProvider.getCityRepository().getByName("Kursk");
        Address address = new Address();
        address.setAddress("Novaya str, 44");
        address.setCity(city);
        address.setDistrict("Lesnoy");
        address.setPhone("333-222-333");
        repositoryProvider.getAddressRepository().save(address);
        customer = new Customer();
        customer.setEmail("VasyaV@gmail.com");
        customer.setAddress(address);
        customer.setActive(true);
        customer.setFirstName("Vasya");
        customer.setLastName("Vasiliev");
        customer.setStore(store);
        return customerRepository.save(customer);

    }



}
