package com.mapsa.onetoonewithsharedprimarykeysample.dto;

import org.springframework.beans.factory.annotation.Value;

public interface PersonDTO {
    public Integer getId();

    @Value("#{target.firstname + ' ' + target.lastname}")
    public String getFullName();

    public IDCard getIdCard();

    public interface IDCard {
        public String getCode();
        public int getId();
    }
}
