package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.javarush.lukyanov.hibernate2.entity.*;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;


public class FilmRepository implements Repository<Film> {


    private final SessionFactory sessionFactory;

    public FilmRepository() {
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
    public Film save(Film film) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(film);
            transaction.commit();
            return session.get(Film.class, film.getFilmId());
        }
    }

    @Override
    public Film update(Film entity) {
        return null;
    }

    @Override
    public Optional<Film> get(long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Film> query = session.createQuery("select f from Film f where f.filmId = :num", Film.class);
            query.setParameter("num", id);
            Film film = query.getSingleResult();
            return Optional.ofNullable(film);
        }
    }

    @Override
    public List<Film> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Film entity) {

    }

    public Film getAvailableFilm() {
        try (Session session = sessionFactory.openSession()) {
            Query<Film> query = session.createQuery("select f from Film f where f.filmId not in (select distinct film.filmId from Inventory)", Film.class);
            query.setMaxResults(1);
            Film film = query.getSingleResult();
            return film;
        }
    }
}
