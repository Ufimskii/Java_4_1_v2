package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book item1 = new Book(1, "Убить Пересмешника", 630, "Ли Харпер");
    private Book item2 = new Book(2, "Рассказы", 850, "Джером К. Джером");
    private Book item3 = new Book(3, "Война Миров", 530, "Герберт Уэллс");
    private Book item4 = new Book(4, "Повелитель мух", 450, "Уильям Голдинг");
    private Smartphone item5 = new Smartphone(5, "IPhone13", 135000, "Apple");
    private Smartphone item6 = new Smartphone(6, "POCO X3 Pro", 22000, "POCO");
    private Smartphone item7 = new Smartphone(7, "Mi11 Ultra", 100000, "XIAOMI");
    private Smartphone item8 = new Smartphone(8, "S21 Plus", 95000, "Samsung");


    @BeforeEach
    public void managerAdd() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
    }


    @Test
    void searchByBookName() {
        String text = "Война Миров";
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        String text = "Джером К. Джером";
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

//    @Test
//    void searchByBookNotValidAuthor() {
//        Product[] expected = new Product[]{};
//        Product[] actual = manager.searchBy("Гербер Уэлс");
//        assertArrayEquals(expected, actual);
//    }

    @Test
    void shouldSearchBySmartphoneName() {
        String text = "IPhone13";
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        String text = "POCO";
        Product[] expected = new Product[]{item6};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

//    @Test
//    void shouldSearchBySmartphoneNotValidManufacturer() {
//        Product[] expected = new Product[]{};
//        Product[] actual = manager.searchBy("PCOC");
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void shouldSearchByAddSomeItems() {
//        Product[] expected = new Product[]{item1};
//        Product[] actual = manager.searchBy("Ли Харпер");
//        assertArrayEquals(expected, actual);
//    }
}