package com.eCommerce.eCommerce.request.categoryRequest;

public class RequestOfCreateForCategory {
    private final String name;

    public RequestOfCreateForCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
