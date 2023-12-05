package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");
    private final String rating;

    Rating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    @Converter(autoApply = true)
    static class RatingConverter implements AttributeConverter<Rating, String> {

        @Override
        public String convertToDatabaseColumn(Rating rating) {
            return rating.getRating();
        }

        @Override
        public Rating convertToEntityAttribute(String s) {
            Rating[] values = Rating.values();
            for (Rating rating : values) {
                if (rating.getRating().equals(s)) {
                    return rating;
                }
            }
            return null;
        }
    }
}
