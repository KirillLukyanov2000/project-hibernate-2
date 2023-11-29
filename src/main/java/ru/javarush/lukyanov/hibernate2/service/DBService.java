package ru.javarush.lukyanov.hibernate2.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DBService<T> {

        private final Class<T> clazz;
    private SessionFactory sessionFactory;

    public DBService(final Class<T> clazzToSet)   {
        this.clazz = clazzToSet;
    }

    public T getById(final long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public List<T> getItems(int from, int count, String sql) {
        Query query = getCurrentSession().createQuery(sql + clazz.getName());
        query.setFirstResult(from);
        query.setMaxResults(count);
        return query.list();
    }

    public List<T> findAll(String sql) {
        return getCurrentSession().createQuery(sql + clazz.getName()).list();
    }

    public T create(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
