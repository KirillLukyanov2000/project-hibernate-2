package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Actor;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class ActorRepository implements Repository<Actor> {
    private final SessionFactory sessionFactory;

    public ActorRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<Actor> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Actor save(Actor entity) {
        return null;
    }

    @Override
    public Actor update(Actor entity) {
        return null;
    }

    @Override
    public Optional<Actor> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Actor> getItems(int offset, int count) {
        try (Session session = sessionFactory.openSession()) {
            Query<Actor> query = session.createQuery("from Actor", Actor.class);
            query.setFirstResult(offset);
            query.setMaxResults(count);
            return query.getResultList();
        }
    }

    @Override
    public void delete(Actor entity) {
    }

}
