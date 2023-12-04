package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.javarush.lukyanov.hibernate2.entity.*;

import ru.javarush.lukyanov.hibernate2.service.CustomerService;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;


public class CustomerRepository implements Repository<Customer> {

    private final SessionFactory sessionFactory;

    public CustomerRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }


    @Override
    public List<Customer> getAll(int pageNumber, int pageSize) {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery(" from Customer", Customer.class);
            query.setFirstResult(pageNumber * pageSize);
            query.setMaxResults(pageSize);
            return query.list();
        }
    }

    @Override
    public Long getAllCount() {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("select count(*) from Customer", Long.class);
            return query.getSingleResult();
        }
    }

    @Override
    public Customer save(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            return session.get(Customer.class, customer.getCustomerId());
        }
    }

    @Override
    public Customer update(Customer player) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer mergedCustomer = (Customer) session.merge(player);
            transaction.commit();
            return mergedCustomer;
        }
    }

    @Override
    public Optional<Customer> get(long id) {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.find(Customer.class, id);
            return Optional.ofNullable(customer);
        }
    }

    @Override
    public List<Customer> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(customer);
            transaction.commit();
        }
    }

    public List<Customer> getItems(int from, int count, String sql) {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery(sql + Customer.class);
            query.setFirstResult(from);
            query.setMaxResults(count);
            return query.list();
        }
    }

}
