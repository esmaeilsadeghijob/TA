package com.mapsa.springDataJPASample.enumeration;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum Gender {
    MALE(0, "مرد", "Male"),
    FEMALE(1, "زن", "Female");

    private final int index;
    private final String persianTitle;
    private final String title;

    Gender(int index, String persianTitle, String title) {
        this.index = index;
        this.persianTitle = persianTitle;
        this.title = title;
    }

    public int getIndex(Gender type) {
        return Optional.ofNullable(type)
                .map(Gender::getIndex)
                .orElse(null);
    }
}
