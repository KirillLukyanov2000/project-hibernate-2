package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
@Entity
@Table(name = "language")
public class Language {
    @Id
    @Column(name = "language_id")
    private Byte languageId;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDate lastUpdate;

    public Language() {
    }

    public Byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
