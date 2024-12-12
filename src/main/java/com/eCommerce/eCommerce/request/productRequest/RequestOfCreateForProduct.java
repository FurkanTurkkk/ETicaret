package com.eCommerce.eCommerce.request.productRequest;

public record RequestOfCreateForProduct(String name,
                                        String categoryName,
                                        double price,
                                        int stock,
                                        String color) {
}
