package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Убить Пересмешника", 630, "Ли Харпер");

    @Test
    public void shouldCompareExistingName() {
        String text = "Убить Пересмешника";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldCompareNotExistingName() {
        String text = "Черный кот";
        assertFalse(book.matches(text));
    }

    @Test
    public void shouldCompareExistingAutor() {
        String text = "Ли Харпер";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldCompareNotExistingAutor() {
        String text = "Эдгар По";
        assertFalse(book.matches(text));
    }

}