package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Category;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class CategoryRepository implements Repository <Category> {
    private final SessionFactory sessionFactory;

    public CategoryRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }
    @Override
    public List<Category> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public Optional<Category> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Category entity) {

    }
}
