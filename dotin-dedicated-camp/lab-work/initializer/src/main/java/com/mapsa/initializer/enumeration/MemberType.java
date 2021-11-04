package com.mapsa.initializer.enumeration;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum MemberType {
    FATHER(0, "پدر", "Father"),
    MOTHER(1, "مادر", "Mother"),
    SISTER(2, "خواهر", "Sister"),
    BROTHER(3, "برادر", "Brother"),
    WIFE(4, "همسر", "Wife"),
    HUSBAND(5, "همسر", "Husband"),
    SON(6, "پسر", "Son"),
    DAUGHTER(7, "دختر", "Daughter");

    private final int index;
    private final String persianTitle;
    private final String title;

    MemberType(int index, String persianTitle, String title) {
        this.index = index;
        this.persianTitle = persianTitle;
        this.title = title;
    }

    public int getIndex(MemberType type) {
        return Optional.ofNullable(type)
                .map(MemberType::getIndex)
                .orElse(null);
    }
}