package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Country;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class CountryRepository implements Repository<Country> {
    private final SessionFactory sessionFactory;

    public CountryRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }


    @Override
    public List<Country> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Country save(Country entity) {
        return null;
    }

    @Override
    public Country update(Country entity) {
        return null;
    }

    @Override
    public Optional<Country> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Country> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Country entity) {

    }
}
