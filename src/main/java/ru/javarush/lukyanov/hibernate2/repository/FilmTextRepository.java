package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Film;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class FilmTextRepository implements Repository <Film>{
    private final SessionFactory sessionFactory;

    public FilmTextRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }
    @Override
    public List<Film> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Film save(Film entity) {
        return null;
    }

    @Override
    public Film update(Film entity) {
        return null;
    }

    @Override
    public Optional<Film> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Film> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Film entity) {

    }
}
