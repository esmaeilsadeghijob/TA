package com.phonebook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBook {
    private String name;
    private String phoneNumber;
    private int id;
}
