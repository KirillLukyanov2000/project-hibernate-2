package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javarush.lukyanov.hibernate2.entity.Address;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;


public class AddressRepository implements Repository<Address> {
    private final SessionFactory sessionFactory;

    public AddressRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<Address> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Address save(Address address) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(address);
            transaction.commit();
            return session.get(Address.class, address.getAddressId());
        }
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public Optional<Address> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Address> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Address address) {

    }
}
