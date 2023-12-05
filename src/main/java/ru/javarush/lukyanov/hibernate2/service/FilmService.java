package ru.javarush.lukyanov.hibernate2.service;

import ru.javarush.lukyanov.hibernate2.entity.*;
import ru.javarush.lukyanov.hibernate2.repository.FilmRepository;
import ru.javarush.lukyanov.hibernate2.service.util.RepositoryProvider;


import java.math.BigDecimal;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmService {
    private Film film;
    private FilmRepository filmRepository;
    private RepositoryProvider repositoryProvider;

    public Film addNewRandomFilm() {
        repositoryProvider = new RepositoryProvider();
        filmRepository = repositoryProvider.getFilmRepository();
        Language language = repositoryProvider.getLanguageRepository().get(1).get();
        List<Category> categories = repositoryProvider.getCategoryRepository().getItems(2, 6);
        List<Actor> actors = repositoryProvider.getActorRepository().getItems(10, 8);

        film = new Film();
        film.setLanguage(language);
        film.setOriginalLanguage(language);
        film.setCategories(new HashSet<>(categories));
        film.setActors(new HashSet<>(actors));
        film.setRating(Rating.PG_13);
        film.setSpecialFeatures(Set.of(SpecialFeature.TRAILERS, SpecialFeature.BEHIND_THE_SCENES));
        film.setDescription("Just another boring movie");
        film.setTitle("Bla-bla-Film");
        film.setRentalRate(BigDecimal.ONE);
        film.setReplacementCost(BigDecimal.valueOf(5));
        film.setReleaseYear(Year.of(2022));
        film.setLength((short) 97);
        film.setRentalDuration((byte) 30);
        filmRepository.save(film);

        FilmText filmText = new FilmText();
        filmText.setFilm(film);
        filmText.setFilmTextId(film.getFilmId());
        filmText.setDescription(film.getDescription());
        filmText.setTitle(film.getTitle());

        repositoryProvider.getFilmTextRepository().save(filmText);
        film.setFilmText(filmText);

        return film;
    }

}
