package com.eCommerce.eCommerce.request.customerRequest;

import java.time.LocalDate;

public class RequestOfCreateForCustomer {
    private final String name;
    private final String surName;
    private final String emailAddress;
    private final String phoneNumber;
    private final LocalDate birthDay;
    private final String tckn;


    public RequestOfCreateForCustomer(String name,
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
