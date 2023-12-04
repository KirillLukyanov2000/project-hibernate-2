package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Rental;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class RentalRepository implements Repository <Rental> {
    private final SessionFactory sessionFactory;

    public RentalRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }
    @Override
    public List<Rental> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Rental save(Rental entity) {
        return null;
    }

    @Override
    public Rental update(Rental entity) {
        return null;
    }

    @Override
    public Optional<Rental> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Rental> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Rental entity) {

    }
}
