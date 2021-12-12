package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product item9 = new Product(9, "Нож", 120);
    private Product item10 = new Product(10, "Вилка", 130);
    private Product item11 = new Product(11, "Ложка", 140);

    @BeforeEach
    public void managerSave() {
        repository.save(item9);
        repository.save(item10);
        repository.save(item11);
    }

    @Test
    public void shouldRemoveByWrongId() {
        int idToRemove = 14;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));

    }


    @Test
    public void shouldRemoveByRightId() {
        int idToRemove = 9;
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{item10, item11};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

//    @Test
//    void shouldEmptyBasket() {
//        Product[] expected = new Product[]{};
//        Product[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void shouldSaveOneItem() {
//        repository.save(item2);
//        Product[] expected = new Product[]{item2};
//        Product[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void shouldSaveSomeItems() {
//        repository.save(item3);
//        repository.save(item4);
//        repository.save(item5);
//        repository.save(item6);
//        Product[] expected = new Product[]{item3, item4, item5, item6};
//        Product[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);
//    }


}