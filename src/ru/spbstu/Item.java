package ru.spbstu;

import java.util.Objects;

public class Item {

    String name;
    Price price;

    public Item(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changePrice(Price newPrice) {
        this.price = newPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Item) {
            Item other = (Item) obj;
            return name.equals(other.name) && price.equals(other.price);
        }
        return false;
    }

    @Override
    public String toString() {
        return ("name: " + this.getName() +
                "   price: " + this.getPrice());
    }

    @Override
    public int hashCode() {
        return (Objects.hash(name, price));
    }
}