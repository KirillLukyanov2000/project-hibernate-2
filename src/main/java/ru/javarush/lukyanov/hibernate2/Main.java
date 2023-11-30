package ru.javarush.lukyanov.hibernate2;



import ru.javarush.lukyanov.hibernate2.entity.Address;
import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.entity.Film;
import ru.javarush.lukyanov.hibernate2.entity.Store;
import ru.javarush.lukyanov.hibernate2.service.CustomerService;
import ru.javarush.lukyanov.hibernate2.service.FilmService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final CustomerService customerService = new CustomerService();
    private static final FilmService filmService = new FilmService();


    public static void main(String[] args) {
        Customer customer = new Customer((short) 501, (byte) 1,"Ivan", "Ivanov", "ivanIvanov@sacilacustomer.org", (short) 506, (byte) 1, LocalDate.of(2016,2,15), LocalDateTime.now(), new Store(), new Address());
        System.out.println(customerService.createCustomer(customer));

        Film film = new Film();
        System.out.println(filmService.addNewFilm(film));

    }
}
