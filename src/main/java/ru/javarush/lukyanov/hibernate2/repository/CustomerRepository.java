package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import ru.javarush.lukyanov.hibernate2.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CustomerRepository implements Repository<Customer> {

    private static CustomerRepository instance;
    private final SessionFactory sessionFactory;

    private CustomerRepository() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.HBM2DDL_AUTO, "validate");
        sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmActor.class)
                .addAnnotatedClass(FilmCategory.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();
    }

    public static CustomerRepository getCustomerRepository() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
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
