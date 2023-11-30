package ru.javarush.lukyanov.hibernate2.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> getAll(int pageNumber, int pageSize);

    Long getAllCount();

    T save(T entity);

    T update(T entity);

    Optional<T> get(long id);

    void delete(T entity);
}
