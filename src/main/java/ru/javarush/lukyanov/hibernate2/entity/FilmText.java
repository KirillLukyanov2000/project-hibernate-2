package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short filmId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    public FilmText() {
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
