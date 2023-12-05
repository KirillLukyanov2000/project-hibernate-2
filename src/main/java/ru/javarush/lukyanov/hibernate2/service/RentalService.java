package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.Rental;
import ru.javarush.lukyanov.hibernate2.repository.RentalRepository;
import ru.javarush.lukyanov.hibernate2.service.util.RepositoryProvider;

import java.time.LocalDateTime;

public class RentalService {
    private Rental rental;
    private RentalRepository rentalRepository;
    private RepositoryProvider repositoryProvider;

    public Rental getFirstUnreturnedRental() {
        repositoryProvider = new RepositoryProvider();
        rentalRepository = repositoryProvider.getRentalRepository();
        rental = rentalRepository.getFirstUnreturnedRental();
        rental.setReturnDate(LocalDateTime.now());
        return rentalRepository.update(rental);
    }
}
