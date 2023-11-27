package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "film_category")
public class FilmCategory {
    @Id
    @Column(name = "film_id")
    private Short filmId;
    @Id
    @Column(name = "category_id")
    private Short categoryId;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public FilmCategory() {
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
