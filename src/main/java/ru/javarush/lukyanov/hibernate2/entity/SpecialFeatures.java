package ru.javarush.lukyanov.hibernate2.entity;

public enum SpecialFeatures {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private final String features;

    SpecialFeatures(String features) {
        this.features = features;
    }
}
