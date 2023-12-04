package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class ActorRepository implements Repository<ActorRepository> {
    private final SessionFactory sessionFactory;

    public ActorRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }


    @Override
    public List<ActorRepository> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public ActorRepository save(ActorRepository entity) {
        return null;
    }

    @Override
    public ActorRepository update(ActorRepository entity) {
        return null;
    }

    @Override
    public Optional<ActorRepository> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<ActorRepository> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(ActorRepository entity) {

    }
}
