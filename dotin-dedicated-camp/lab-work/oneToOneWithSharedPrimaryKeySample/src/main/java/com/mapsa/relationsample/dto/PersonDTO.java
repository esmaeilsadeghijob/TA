package com.mapsa.relationsample.dto;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public interface PersonDTO extends Serializable {
    public Integer getId();

    @Value("#{target.firstname + ' ' + target.lastname}")
    public String getFullName();

    public IDCardDTO getIdCard();

    public interface IDCardDTO extends Serializable {
        public String getCode();

        public int getId();
    }
}
