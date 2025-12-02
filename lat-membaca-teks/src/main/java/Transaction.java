package org.example;

public class Transaction {
    public int id;
    public String item;
    public int quantity;
    public double price;

    public Transaction(int id, String item, int quantity, double price) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return id + "," + item + "," + quantity + "," + price;
    }
}