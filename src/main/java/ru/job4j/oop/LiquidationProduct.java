package ru.job4j.oop;

public class final LiquidationProduct {
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public String label() {
        return product.label();
    }
}
