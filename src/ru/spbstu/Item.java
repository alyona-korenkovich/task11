package ru.spbstu;

public class Item {
    String name;
    int code;
    double price;

    public Item(String name, int code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public double getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Item) {
            Item other = (Item) obj;
            return name.equals(other.name) && price == other.price && code == other.code;
        }
        return false;
    }

    public String toString() {
        return ("name: " + this.getName() +
                "\nprice: " + this.getPrice() +
                "\ncode: " + this.getCode());
    }
}