package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Payment;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class PaymentRepository implements Repository <Payment> {
    private final SessionFactory sessionFactory;

    public PaymentRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }
    @Override
    public List<Payment> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Payment save(Payment entity) {
        return null;
    }

    @Override
    public Payment update(Payment entity) {
        return null;
    }

    @Override
    public Optional<Payment> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Payment> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Payment entity) {

    }
}
