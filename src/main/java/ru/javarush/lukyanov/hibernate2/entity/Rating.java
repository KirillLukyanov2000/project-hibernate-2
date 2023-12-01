package ru.javarush.lukyanov.hibernate2.entity;

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
}
