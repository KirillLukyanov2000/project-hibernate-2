package ru.javarush.lukyanov.hibernate2.service.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;
import java.util.Objects;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year year) {
        if (Objects.nonNull(year)) {
            return (short) year.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Short aShort) {
        if (Objects.nonNull(aShort)) {
            return Year.of(aShort);
        }
        return null;
    }
}
