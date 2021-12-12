package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll())
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        return result;
    }
//
//    public boolean matches(Product product, String search) {
//        if (product instanceof Book) {
//            Book book = (Book) product;
//            if (book.getName().equalsIgnoreCase(search)) {
//                return true;
//            }
//            return book.getAuthor().equalsIgnoreCase(search);
//        }
//        if (product instanceof Smartphone) {
//            Smartphone smartphone = (Smartphone) product;
//            if (smartphone.getName().equalsIgnoreCase(search)) {
//                return true;
//            }
//            return smartphone.getManufacturer().equalsIgnoreCase(search);
//        }
//        return false;
//    }
}