package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "film_id")
    private Short filmId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    @Basic
    private java.sql.Date releaseYear;
    @Column(name = "language_id")
    private Byte languageId;
    @Column(name = "original_language_id")
    private Byte originalLanguageId;
    @Column(name = "rental_duration")
    private Byte rentalDuration;
    @Column(name = "rental_rate")
    private java.math.BigDecimal rentalRate;
    @Column(name = "length")
    private Short length;
    @Column(name = "replacement_cost")
    private java.math.BigDecimal replacementCost;
    @Column(name = "rating")
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;
    @Column(name = "special_features")
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private Set<SpecialFeatures> specialFeatures;
    @OneToOne
    @JoinColumn(name = "film_id",referencedColumnName = "filmId")
    private FilmText filmText;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Film() {
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

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    public Byte getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Byte originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Set<SpecialFeatures> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Set<SpecialFeatures> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
