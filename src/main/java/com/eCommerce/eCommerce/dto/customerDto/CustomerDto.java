package com.eCommerce.eCommerce.dto.customerDto;

import java.time.LocalDate;

public class CustomerDto {
    private  String name;
    private  String surName;
    private  String emailAddress;
    private  String phoneNumber;
    private  LocalDate birthDay;
    private  String tckn;

    public CustomerDto(String name,
                       String surName,
                       String emailAddress,
                       String phoneNumber,
                       LocalDate birthDay,
                       String tckn) {
        this.name = name;
        this.surName = surName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.tckn = tckn;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getTckn() {
        return tckn;
    }
}
