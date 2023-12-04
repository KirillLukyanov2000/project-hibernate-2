package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.entity.Inventory;
import ru.javarush.lukyanov.hibernate2.repository.InventoryRepository;

public class InventoryService {
    private Inventory inventory;
    private InventoryRepository inventoryRepository;
    private RepositoryProvider repositoryProvider;

    public Inventory customerReturnsInventory(Customer customer) {
        repositoryProvider = new RepositoryProvider();
        inventoryRepository = repositoryProvider.getInventoryRepository();
        inventory = new Inventory();
        return inventory;
    }
}
