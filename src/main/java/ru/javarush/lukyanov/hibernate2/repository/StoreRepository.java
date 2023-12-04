package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Store;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class StoreRepository implements Repository<Store> {

    private final SessionFactory sessionFactory;

    public StoreRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<Store> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Store save(Store entity) {
        return null;
    }

    @Override
    public Store update(Store entity) {
        return null;
    }

    @Override
    public Optional<Store> get(long id) {
        try (Session session = sessionFactory.openSession()) {
            Store store = session.find(Store.class, id);
            return Optional.ofNullable(store);
        }
    }

    @Override
    public List<Store> getItems(int offset, int count) {
        try (Session session = sessionFactory.openSession()) {
            Query <Store> query = session.createQuery("from Store", Store.class);
            query.setFirstResult(offset);
            query.setMaxResults(count);
            return query.getResultList();
        }

    }

    @Override
    public void delete(Store entity) {

    }
}
