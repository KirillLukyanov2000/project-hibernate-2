package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javarush.lukyanov.hibernate2.entity.Inventory;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class InventoryRepository implements Repository<Inventory> {
    private final SessionFactory sessionFactory;

    public InventoryRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<Inventory> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Inventory save(Inventory inventory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(inventory);
            transaction.commit();
            return session.get(Inventory.class, inventory.getInventoryId());
        }
    }

    @Override
    public Inventory update(Inventory entity) {
        return null;
    }

    @Override
    public Optional<Inventory> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Inventory> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Inventory entity) {

    }
}
