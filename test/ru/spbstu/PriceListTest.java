package ru.spbstu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PriceListTest {

    Item pen = new Item("Pen", new Price(30, 90));
    Item brush = new Item("Brush", new Price(150, 99));
    Item brushWithNewName = new Item("Brush 3000", new Price(150, 99));
    Item paint = new Item("Paint", new Price(699, 99));
    Item clay = new Item("Clay", new Price(95, 99));
    Item clayWithChangedPrice = new Item("Clay", new Price(65, 99));
    Item pencil = new Item("Pencil", new Price(20, 60));

    private PriceList testList = new PriceList();
    private PriceList actual = new PriceList();
    private PriceList expected = new PriceList();

    @Before
    public void setUp() {
        testList.setItem(19389, pencil);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void setItem() {
        Item res = testList.setItem(19389, pen);
        assertEquals(res, pencil);

        Item res1 = testList.setItem(19390, brush);
        System.out.println(testList);
        assertNull(res1);
    }

    @Test
    public void delete() {
        Item res = testList.delete(19389);
        System.out.println(testList);
        assertEquals(res, pencil);

        exceptionRule.expect(IllegalArgumentException.class);
        actual.delete(17234);
    }

    @Test
    public void changeItemPrice() {
        expected.setItem(19389, pen);
        expected.setItem(19390, brush);
        expected.setItem(19391, paint);
        expected.setItem(19392, clayWithChangedPrice);

        actual.setItem(19389, pen);
        actual.setItem(19390, brush);
        actual.setItem(19391, paint);
        actual.setItem(19392, clay);
        actual.changeItemPrice(19392, new Price(65, 99));

        assertEquals(expected, actual);
    }

    @Test
    public void changeItemName() {
        expected.setItem(19389, pen);
        expected.setItem(19390, brushWithNewName);
        expected.setItem(19391, paint);
        expected.setItem(19392, clay);

        actual.setItem(19389, pen);
        actual.setItem(19390, brush);
        actual.setItem(19391, paint);
        actual.setItem(19392, clay);
        actual.changeItemName(19390, "Brush 3000");

        assertEquals(expected, actual);
    }

    @Test
    public void whatIsThePrice() {
        int amount = 3;
        Price expectedList = new Price(287, 97);

        actual.setItem(19389, pen);
        actual.setItem(19390, brush);
        actual.setItem(19391, paint);
        actual.setItem(19392, clay);
        Price actualList = actual.whatIsThePrice(19392, amount);

        assertEquals(expectedList, actualList);
    }
}