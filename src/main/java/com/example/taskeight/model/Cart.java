package com.example.taskeight.model;

import com.example.taskeight.model.Product;

public class Cart extends Product {
    private int quantity;
    public Cart(){
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
