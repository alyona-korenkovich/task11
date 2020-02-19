package ru.spbstu;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class PriceListTest {

    Item pen = new Item("Pen", 30.99);
    Item brush = new Item("Brush", 150.99);
    Item brushWithNewName = new Item("Brush 3000", 150.99);
    Item paint = new Item("Paint", 699.99);
    Item clay = new Item("Clay", 95.99);
    Item clayWithChangedPrice = new Item("Clay", 65.99);

    @Test
    public void setItem() {
        HashMap<Integer, Item> testMap = new HashMap<>();
        testMap.put(17309, pen);
        PriceList expected = new PriceList(testMap);

        PriceList actual = new PriceList(new HashMap<>());
        actual.setItem(17309, pen);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        HashMap<Integer, Item> testMap = new HashMap<>();
        testMap.put(19389, pen);
        testMap.put(19390, brush);
        testMap.put(19392, clay);
        PriceList expected = new PriceList(testMap);

        HashMap<Integer, Item> testMap1 = new HashMap<>();
        testMap1.put(19389, pen);
        testMap1.put(19390, brush);
        testMap1.put(19391, paint);
        testMap1.put(19392, clay);
        PriceList actual = new PriceList(testMap1);
        actual.delete(19391);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeItemPrice() {
        HashMap<Integer, Item> testMap = new HashMap<>();
        testMap.put(19389, pen);
        testMap.put(19390, brush);
        testMap.put(19391, paint);
        testMap.put(19392, clayWithChangedPrice);
        PriceList expected = new PriceList(testMap);

        HashMap<Integer, Item> testMap1 = new HashMap<>();
        testMap1.put(19389, pen);
        testMap1.put(19390, brush);
        testMap1.put(19391, paint);
        testMap1.put(19392, clay);
        PriceList actual = new PriceList(testMap1);
        actual.changeItemPrice(19392, 65.99);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeItemName() {
        HashMap<Integer, Item> testMap = new HashMap<>();
        testMap.put(19389, pen);
        testMap.put(19390, brushWithNewName);
        testMap.put(19391, paint);
        testMap.put(19392, clay);
        PriceList expected = new PriceList(testMap);

        HashMap<Integer, Item> testMap1 = new HashMap<>();
        testMap1.put(19389, pen);
        testMap1.put(19390, brush);
        testMap1.put(19391, paint);
        testMap1.put(19392, clay);
        PriceList actual = new PriceList(testMap1);
        actual.changeItemName(19390, "Brush 3000");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whatIsThePrice() {
        int amount = 3;
        double expected = 95.99 * amount;

        HashMap<Integer, Item> testMap1 = new HashMap<>();
        testMap1.put(19389, pen);
        testMap1.put(19390, brush);
        testMap1.put(19391, paint);
        testMap1.put(19392, clay);
        PriceList actualList = new PriceList(testMap1);
        double actual = actualList.whatIsThePrice(19392, amount);

        Assert.assertEquals(expected, actual, 0.0);
    }
}