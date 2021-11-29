package com.mapsa.security.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Role implements GrantedAuthority {
    ADMIN(1, "مدیر", "Admin"),
    EMPLOYEE(2, "کارمند", "Employee"),
    USER(3, "کاربر معمولی", "User");

    private final int    index;
    private final String persianTitle;
    private final String title;

    Role(int index, String persianTitle, String title) {
        this.index = index;
        this.persianTitle = persianTitle;
        this.title = title;
    }

    @Override
    public String getAuthority() {
        return this.getTitle();
    }
}
