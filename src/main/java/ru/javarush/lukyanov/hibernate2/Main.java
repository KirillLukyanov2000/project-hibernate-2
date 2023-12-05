package ru.javarush.lukyanov.hibernate2;


import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.entity.Film;
import ru.javarush.lukyanov.hibernate2.entity.Inventory;
import ru.javarush.lukyanov.hibernate2.service.CustomerService;
import ru.javarush.lukyanov.hibernate2.service.FilmService;
import ru.javarush.lukyanov.hibernate2.service.InventoryService;


public class Main {
    private static final CustomerService customerService = new CustomerService();
    private static final InventoryService inventoryService = new InventoryService();
    private static final FilmService filmService = new FilmService();


    public static void main(String[] args) {

        Customer newRandomCustomer = customerService.addNewRandomCustomer();

        Inventory returnedInventory = inventoryService.returnInventory();

        Inventory rentedInventory = inventoryService.rentInventory(newRandomCustomer);

        Film film = filmService.addNewRandomFilm();


    }
}
