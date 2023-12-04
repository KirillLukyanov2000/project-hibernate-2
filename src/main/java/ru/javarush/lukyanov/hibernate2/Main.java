package ru.javarush.lukyanov.hibernate2;




import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.entity.Inventory;
import ru.javarush.lukyanov.hibernate2.service.CustomerService;
import ru.javarush.lukyanov.hibernate2.service.FilmService;
import ru.javarush.lukyanov.hibernate2.service.InventoryService;


public class Main {
    private static final CustomerService customerService = new CustomerService();
    private static final InventoryService inventoryService = new InventoryService();


    public static void main(String[] args) {

        Customer newRandomCustomer = customerService.createNewRandomCustomer();

        Inventory ReturnedInventory = inventoryService.customerReturnsInventory(newRandomCustomer);




    }
}
