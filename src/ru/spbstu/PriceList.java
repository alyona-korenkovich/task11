package ru.spbstu;

import java.util.ArrayList;

public class PriceList {

    ArrayList<Item> priceList;

    public PriceList(ArrayList<Item> priceList){
        this.priceList = priceList;
    }

    public void setItem(Item item){
        priceList.add(item);
    }

    public void delete(String name){
        int index = -1;
        for (Item element : priceList) {
            if (element.getName().equals(name)) {
                index = priceList.indexOf(element);
                break;
            }
        }
        if (index != -1) {
            priceList.remove(index);
        }
    }

    public void changeItemPrice(String name, double newPrice){
        int index = -1;
        for (Item element : priceList) {
            if (element.getName().equals(name)) {
                index = priceList.indexOf(element);
                break;
            }
        }
        if (index != -1) {
            priceList.get(index).changePrice(newPrice);
        }
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
        priceList.forEach((Item) -> result.append(Item).append("\n"));
        return result.toString();
    }
}