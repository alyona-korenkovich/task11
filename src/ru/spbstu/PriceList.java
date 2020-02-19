package ru.spbstu;

import java.util.HashMap;

public class PriceList {

    HashMap<Integer, Item> priceList;

    public PriceList(HashMap<Integer, Item> priceList) {
        this.priceList = priceList;
    }

    public void setItem(int code, Item item) {
        priceList.put(code, item);
    }

    public void delete(int code) {
        priceList.remove(code);
    }

    public void changeItemPrice(int code, double newPrice) {
        priceList.get(code).changePrice(newPrice);
    }

    public void changeItemName(int code, String newName) {
        priceList.get(code).changeName(newName);
    }

    public double whatIsThePrice(int code, int amount) {
        return priceList.get(code).getPrice() * amount;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof PriceList) {
            PriceList other = (PriceList) obj;
            return priceList.equals(other.priceList);
        }
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        priceList.forEach((Integer, Item) -> result.append("code: ").append(Integer).append("\n").
                append("item: ").append(Item).append("\n"));
        return result.toString();
    }
}