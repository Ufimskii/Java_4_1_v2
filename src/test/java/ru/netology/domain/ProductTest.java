package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(55, "Сок Rich", 100);

    @Test
    public void shouldCompareExistingName() {
        String text = "Сок Rich";
        assertTrue(product.matches(text));
    }

    @Test
    public void shouldCompareNotExistingName() {
        String text = "Сок Я";
        assertFalse(product.matches(text));
    }
}