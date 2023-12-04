package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.Session;
import ru.javarush.lukyanov.hibernate2.entity.Store;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> getAll(int pageNumber, int pageSize);

    Long getAllCount();

    T save(T entity);

    T update(T entity);

    Optional<T> get(long id);

    List<T> getItems(int offset, int count);

    void delete(T entity);
}
