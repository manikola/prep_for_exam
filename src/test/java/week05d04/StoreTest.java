package week05d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {



    @Test
    void addProducts() {

        Product product1 = new Product("alma", 2020, 10, 12);
        Product product2 = new Product("tejföl", 2020, 12, 10);
        Product product3 = new Product("kenyér", 2020, 11, 30);
        Product product4 = new Product("zabpehely", 2021, 5, 26);
        Product product5 = new Product("csoki", 2020, 11, 2);

        Store store = new Store();

        store.addProducts(product1);
        store.addProducts(product2);
        store.addProducts(product3);
        store.addProducts(product4);
        store.addProducts(product5);

        assertEquals(5, store.getProducts().size());
    }

    @Test
    void getNumberOfExpired() {
        Product product1 = new Product("alma", 2020, 10, 12);
        Product product2 = new Product("tejföl", 2020, 12, 10);
        Product product3 = new Product("kenyér", 2020, 11, 30);
        Product product4 = new Product("zabpehely", 2021, 5, 26);
        Product product5 = new Product("csoki", 2020, 11, 2);

        Store store = new Store();

        store.addProducts(product1);
        store.addProducts(product2);
        store.addProducts(product3);
        store.addProducts(product4);
        store.addProducts(product5);

        assertEquals(4, store.getNumberOfExpired());
    }
}