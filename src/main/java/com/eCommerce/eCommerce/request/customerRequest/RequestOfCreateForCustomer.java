package com.eCommerce.eCommerce.request.customerRequest;

import java.time.LocalDate;

public record RequestOfCreateForCustomer(String name,
                                         String surName,
                                         String emailAddress,
                                         String phoneNumber,
                                         LocalDate birthDay,
                                         String tckn) {
}
