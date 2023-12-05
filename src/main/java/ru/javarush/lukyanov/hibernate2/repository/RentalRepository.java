package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.javarush.lukyanov.hibernate2.entity.Rental;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;


import java.util.List;
import java.util.Optional;

public class RentalRepository implements Repository<Rental> {
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
    public Rental save(Rental rental) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(rental);
            transaction.commit();
            return session.get(Rental.class, rental.getRentalId());
        }
    }

    @Override
    public Rental update(Rental rental) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Rental mergedRental = (Rental) session.merge(rental);
            transaction.commit();
            return mergedRental;
        }
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

    public Rental getFirstUnreturnedRental() {
        try (Session session = sessionFactory.openSession()) {
            Query<Rental> query = session.createQuery("select r from Rental r where r.returnDate is null", Rental.class);
            query.setMaxResults(1);
            Rental rental = query.getSingleResult();
            return rental;
        }
    }
}
