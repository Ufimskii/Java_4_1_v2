package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(5, "IPhone13", 135000, "Apple");

    @Test
    public void shouldCompareExistingName() {
        String text = "IPhone13";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void shouldCompareNotExistingName() {
        String text = "IPhone7 Plus";
        assertFalse(smartphone.matches(text));
    }

    @Test
    public void shouldCompareExistingManufacturer() {
        String text = "Apple";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void shouldCompareNotExistingManufacturer() {
        String text = "POCO";
        assertFalse(smartphone.matches(text));
    }
}