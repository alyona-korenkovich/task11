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
        try {
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
        catch (java.lang.IndexOutOfBoundsException ex) {
            System.out.println("Item with this name is not found. Try again.");
        }
    }

    public void changeItemPrice(String name, double newPrice){
        try {
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
        catch (java.lang.IndexOutOfBoundsException ex) {
            System.out.println("Item with this name is not found. Try again.");
        }
    }

    public void changeItemName(String name, String newName){
        int index = -1;
        for (Item element : priceList) {
            if (element.getName().equals(name)) {
                index = priceList.indexOf(element);
                break;
            }
        }
        if (index != -1) {
            priceList.get(index).changeName(newName);
        }
    }

    public double whatIsThePrice(int code, int amount){
        double currentPrice = 0.0;
        try {
            int index = -1;
            for (Item element : priceList) {
                if (element.getCode() == code) {
                    index = priceList.indexOf(element);
                    break;
                }
            }
            if (index != 1) {
                currentPrice = amount * priceList.get(index).getPrice();
            }
        }
        catch (java.lang.IndexOutOfBoundsException ex) {
            System.out.println("Item with this code is not found. Try again.");
        }
        return currentPrice;
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