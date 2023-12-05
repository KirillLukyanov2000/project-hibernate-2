package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.*;
import ru.javarush.lukyanov.hibernate2.repository.CustomerRepository;
import ru.javarush.lukyanov.hibernate2.service.util.RepositoryProvider;

public class CustomerService {
    private Customer customer;
    private CustomerRepository customerRepository;
    private RepositoryProvider repositoryProvider;

    public Customer addNewRandomCustomer() {
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
