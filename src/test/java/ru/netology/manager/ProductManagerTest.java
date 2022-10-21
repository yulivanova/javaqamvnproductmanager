package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product product = new Product(22, "Jacket", 1_000);
    Product book = new Book(11, "Book first", 100, "Author first");
    Product smartphone = new Smartphone(33, "Iphone first", 100_000, "Apple");


    @Test
    public void shouldAdd() {

        manager.add(smartphone);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddAll() {

        manager.add(product);
        manager.add(book);
        manager.add(smartphone);

        Product[] actual = repo.findAll();
        Product[] expected = {product, book, smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBy() {

        manager.add(product);
        manager.add(book);
        manager.add(smartphone);
        String title = "Iphone";

        Product[] actual = manager.searchBy(title);
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBy1() {

        manager.add(product);
        manager.add(book);
        manager.add(smartphone);
        String title = "Honor";

        Product[] actual = manager.searchBy(title);
        Product[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBy2() {

        manager.add(product);
        manager.add(book);
        manager.add(smartphone);
        String title = "first";

        Product[] actual = manager.searchBy(title);
        Product[] expected = {book, smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }
}




