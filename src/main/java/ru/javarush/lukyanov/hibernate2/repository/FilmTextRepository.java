package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.javarush.lukyanov.hibernate2.entity.FilmText;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class FilmTextRepository implements Repository<FilmText> {
    private final SessionFactory sessionFactory;

    public FilmTextRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<FilmText> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public FilmText save(FilmText filmText) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(filmText);
            transaction.commit();
            return session.get(FilmText.class, filmText.getFilmTextId());
        }
    }

    @Override
    public FilmText update(FilmText entity) {
        return null;
    }

    @Override
    public Optional<FilmText> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<FilmText> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(FilmText entity) {

    }
}
