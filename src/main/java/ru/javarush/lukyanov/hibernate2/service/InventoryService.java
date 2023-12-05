package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.*;
import ru.javarush.lukyanov.hibernate2.repository.InventoryRepository;
import ru.javarush.lukyanov.hibernate2.service.util.RepositoryProvider;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryService {
    private Inventory inventory;
    private InventoryRepository inventoryRepository;
    private RepositoryProvider repositoryProvider;

    public Inventory returnInventory() {
        repositoryProvider = new RepositoryProvider();
        inventoryRepository = repositoryProvider.getInventoryRepository();
        Rental rental = new RentalService().getFirstUnreturnedRental();
        inventory = rental.getInventory();
        return inventory;
    }

    public Inventory rentInventory(Customer customer) {
        repositoryProvider = new RepositoryProvider();
        inventoryRepository = repositoryProvider.getInventoryRepository();
        Film film = repositoryProvider.getFilmRepository().getAvailableFilm();
        Store store = repositoryProvider.getStoreRepository().getItems(0, 1).get(0);
        inventory = new Inventory();
        inventory.setFilm(film);
        inventory.setStore(store);
        inventoryRepository.save(inventory);

        Staff staff = store.getStaff();
        Rental rental = new Rental();
        rental.setRentalDate(LocalDateTime.now());
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setStaff(staff);
        repositoryProvider.getRentalRepository().save(rental);

        Payment payment = new Payment();
        payment.setPaymentDate(LocalDateTime.now());
        payment.setCustomer(customer);
        payment.setRental(rental);
        payment.setAmount(BigDecimal.valueOf(34.21));
        payment.setStaff(staff);
        repositoryProvider.getPaymentRepository().save(payment);

        return inventory;
    }
}
