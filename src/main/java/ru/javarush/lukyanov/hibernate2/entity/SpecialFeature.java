package ru.javarush.lukyanov.hibernate2.entity;

import static java.util.Objects.isNull;

public enum SpecialFeature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private final String feature;

    SpecialFeature(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }

    public static SpecialFeature getSpecialFeatureByValue(String feature) {
        if (isNull(feature) || feature.isEmpty()) {
            return null;
        }
        SpecialFeature[] specialFeatures = SpecialFeature.values();
        for (SpecialFeature specialFeature : specialFeatures) {
            if (specialFeature.feature.equals(feature)) {
                return specialFeature;
            }
        }
        return null;
    }
}
