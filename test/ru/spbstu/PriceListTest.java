package ru.spbstu;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class PriceListTest {

    Item item = new Item ("keyboard", 10937, 1299.99);
    Item item1 = new Item ("mouse", 11984, 599.99);
    Item item2 = new Item ("screen", 19853, 5899.99);
    Item item1Changed = new Item ("mouse", 11984, 999.99);

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
}