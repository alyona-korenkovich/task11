package ru.spbstu;

public class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Item) {
            Item other = (Item) obj;
            return name.equals(other.name) && price == other.price;
        }
        return false;
    }

    public String toString() {
        return ("name: " + this.getName() +
                "\nprice: " + this.getPrice());
    }
}