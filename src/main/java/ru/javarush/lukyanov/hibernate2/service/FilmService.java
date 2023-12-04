package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.Customer;
import ru.javarush.lukyanov.hibernate2.entity.Film;
import ru.javarush.lukyanov.hibernate2.repository.CustomerRepository;
import ru.javarush.lukyanov.hibernate2.repository.FilmRepository;

public class FilmService {
    private Film film;
    private FilmRepository filmRepository;

    public Film addNewFilm(Film film) {
        filmRepository = new RepositoryProvider().getFilmRepository();
        return filmRepository.save(film);
    }
}
