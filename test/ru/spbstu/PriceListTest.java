package ru.spbstu;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class PriceListTest {

    Item item = new Item ("keyboard", 10937, 1299.99);
    Item item1 = new Item ("mouse", 11984, 599.99);
    Item item2 = new Item ("screen", 19853, 5899.99);
    Item item1Changed = new Item ("mouse", 11984, 999.99);
    Item item1Changed2 = new Item ("mouse 3000", 11984, 599.99);

    @Test
    public void setItem() {
        PriceList actual = new PriceList(new ArrayList<Item>());
        actual.setItem(item);
        actual.setItem(item1);
        actual.setItem(item2);

        ArrayList<Item> testList = new ArrayList<>();
        testList.add(item);
        testList.add(item1);
        testList.add(item2);
        PriceList expected = new PriceList(testList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        PriceList actual = new PriceList(new ArrayList<Item>());
        actual.setItem(item);
        actual.setItem(item1);
        actual.setItem(item2);
        actual.delete(item1.name);

        ArrayList<Item> testList = new ArrayList<>();
        testList.add(item);
        testList.add(item2);
        PriceList expected = new PriceList(testList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeItemPrice() {
        PriceList actual = new PriceList(new ArrayList<Item>());
        actual.setItem(item);
        actual.setItem(item1);
        actual.setItem(item2);
        actual.changeItemPrice(item1.name, 999.99);

        ArrayList<Item> testList = new ArrayList<>();
        testList.add(item);
        testList.add(item1Changed);
        testList.add(item2);
        PriceList expected = new PriceList(testList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeItemName() {
        PriceList actual = new PriceList(new ArrayList<Item>());
        actual.setItem(item);
        actual.setItem(item1);
        actual.setItem(item2);
        actual.changeItemName(item1.name, "mouse 3000");

        ArrayList<Item> testList = new ArrayList<>();
        testList.add(item);
        testList.add(item1Changed2);
        testList.add(item2);
        PriceList expected = new PriceList(testList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whatIsThePrice() {
        int amount = 3;
        //chosen item is item 2, its code is 19853

        double expected = amount * item2.getPrice();

        PriceList testList = new PriceList(new ArrayList<Item>());
        testList.setItem(item);
        testList.setItem(item1);
        testList.setItem(item2);
        double actual = testList.whatIsThePrice(item2.getCode(), amount);
        boolean result = (expected == actual);

        Assert.assertEquals(result, true);
    }
}