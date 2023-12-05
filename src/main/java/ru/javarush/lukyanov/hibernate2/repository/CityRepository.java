package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.City;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class CityRepository implements Repository<City> {
    private final SessionFactory sessionFactory;

    public CityRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<City> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public City save(City entity) {
        return null;
    }

    @Override
    public City update(City entity) {
        return null;
    }

    @Override
    public Optional<City> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<City> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(City entity) {

    }

    public City getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery("select c from City c where c.city = :name", City.class);
            query.setParameter("name", name);
            query.setMaxResults(1);
            return query.getSingleResult();
        }
    }
}
