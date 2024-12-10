package com.eCommerce.eCommerce.request;

public class RequestOfCreateForCategory {
    private final String name;

    public RequestOfCreateForCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
