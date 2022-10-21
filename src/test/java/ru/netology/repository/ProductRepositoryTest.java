package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {

    private final ProductRepository repo = new ProductRepository();

    Product product = new Product(22, "Jacket", 1_000);
    Product book = new Book(11, "Book first", 100, "Author first");
    Product smartphone = new Smartphone(33, "Iphone", 100_000, "Apple");

    @Test
    public void shouldSaveOne() {

        repo.save(smartphone);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAll() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);

        Product[] actual = repo.findAll();
        Product[] expected = {product, book, smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveById() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(product.getId());

        Product[] actual = repo.findAll();
        Product[] expected = {book, smartphone};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveByIdAll() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(product.getId());
        repo.removeById(book.getId());
        repo.removeById(smartphone.getId());

        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }
}








