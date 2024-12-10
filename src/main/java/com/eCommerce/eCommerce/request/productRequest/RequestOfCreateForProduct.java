package com.eCommerce.eCommerce.request.productRequest;


public class RequestOfCreateForProduct {
    private String name;
    private Long categoryId;
    private double price;
    private int stock;
    private String color;

    public RequestOfCreateForProduct(String name, Long categoryId, double price, int stock,String color) {
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.color=color;
    }

    public String getName() {
        return name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getColor() {
        return color;
    }
}
