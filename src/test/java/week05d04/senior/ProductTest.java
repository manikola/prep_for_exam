package week05d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void convertPrice() {
        Product p1 = new Product(600, Currency.HUF);
        Product p2 = new Product(6, Currency.USD);

        assertEquals(2.0,p1.convertPrice(Currency.USD));
        assertEquals(1800.0,p2.convertPrice(Currency.HUF));
    }
}