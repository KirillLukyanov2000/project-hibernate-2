package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.javarush.lukyanov.hibernate2.entity.Language;
import ru.javarush.lukyanov.hibernate2.service.util.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class LanguageRepository implements Repository<Language> {
    private final SessionFactory sessionFactory;

    public LanguageRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    @Override
    public List<Language> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Language save(Language entity) {
        return null;
    }

    @Override
    public Language update(Language entity) {
        return null;
    }

    @Override
    public Optional<Language> get(long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Language> query = session.createQuery("select l from Language l where l.languageId = :num", Language.class);
            query.setParameter("num", (byte) id);
            Language language = query.getSingleResult();
            return Optional.ofNullable(language);
        }
    }

    @Override
    public List<Language> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Language entity) {

    }
}
