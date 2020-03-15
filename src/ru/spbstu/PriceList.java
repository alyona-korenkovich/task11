package ru.spbstu;

import java.util.HashMap;
import java.util.Objects;

public class PriceList {

    private HashMap<Integer, Item> priceList = new HashMap<>();

    public Item setItem(int code, Item item) {
        Item res = priceList.get(code);
        priceList.put(code, item);
        return res;
    }

    public Item delete(int code) {
        if (!priceList.containsKey(code)) throw new IllegalArgumentException();
        Item res = priceList.get(code);
        priceList.remove(code);
        return res;
    }

    public Item getItem(int code) {
        return priceList.get(code);
    }

    public void changeItemPrice(int code, Price newPrice) {
        if (!priceList.containsKey(code)) throw new IllegalArgumentException();
        priceList.get(code).changePrice(newPrice);
    }

    public void changeItemName(int code, String newName) {
        if (!priceList.containsKey(code)) throw new IllegalArgumentException();
        priceList.get(code).changeName(newName);
    }

    public Price whatIsThePrice(int code, int amount) {
        if (!priceList.containsKey(code)) throw new IllegalArgumentException();
        int rublesInPennies = priceList.get(code).getPrice().getRubles() * 100;
        int pennies = priceList.get(code).getPrice().getPennies();
        int currentPriceInPennies = (rublesInPennies + pennies) * amount;
        int newRubles = currentPriceInPennies / 100;
        int newPennies = currentPriceInPennies - newRubles * 100;
        return new Price(newRubles, newPennies);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof PriceList) {
            PriceList other = (PriceList) obj;
            return priceList.equals(other.priceList);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        priceList.forEach((Integer, Item) -> result.append("code: ").append(Integer).append("   ").
                append("item: ").append(Item).append("\n"));
        return result.toString();
    }

    @Override
    public int hashCode() {
        return (Objects.hash(priceList));
    }
}