package ru.javarush.lukyanov.hibernate2.repository;

import org.hibernate.SessionFactory;
import ru.javarush.lukyanov.hibernate2.entity.Staff;
import ru.javarush.lukyanov.hibernate2.service.SessionFactoryProvider;

import java.util.List;
import java.util.Optional;

public class StaffRepository implements Repository <Staff> {

    private final SessionFactory sessionFactory;

    public StaffRepository() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }
    @Override
    public List<Staff> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public Staff save(Staff entity) {
        return null;
    }

    @Override
    public Staff update(Staff entity) {
        return null;
    }

    @Override
    public Optional<Staff> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Staff> getItems(int offset, int count) {
        return null;
    }

    @Override
    public void delete(Staff entity) {

    }
}
