package week02d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void areTheyEqual() {
        Product a = new Product("szappan", "dove12");
        Product b = new Product("szappan", "dove123");
        Product c = new Product("szappan", "dove1223");

        assertTrue(a.areTheyEqual(b));
        assertTrue(a.areTheyEqual(c));
        assertTrue(b.areTheyEqual(c));
    }

    @Test
    void areTheyEqualOther() {
        Product a = new Product("szappan", "dove12");
        Product b = new Product("szappan", "dove123");
        Product c = new Product("szappan", "dove1223");

        assertTrue(a.areTheyEqualOther(b));
        assertTrue(b.areTheyEqualOther(c));
        assertFalse(a.areTheyEqualOther(c));

    }
}