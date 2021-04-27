package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void getProductList() {
        List<Product> products= new ArrayList<>();
        products.add(new Product("alma", Category.OTHER, 125));
        products.add(new Product("kenyér", Category.BAKED_GOODS, 125));
        products.add(new Product("tej", Category.DAIRY, 125));
        products.add(new Product("pizza", Category.FROZEN, 125));
        products.add(new Product("icecream", Category.FROZEN, 125));
        Store s = new Store(products);

        assertEquals(5,s.getProductList().size());
    }

    @Test
    void addProducts() {
        List<Product> products= new ArrayList<>();
        products.add(new Product("alma", Category.OTHER, 125));
        products.add(new Product("kenyér", Category.BAKED_GOODS, 125));
        products.add(new Product("tej", Category.DAIRY, 125));
        products.add(new Product("pizza", Category.FROZEN, 125));
        products.add(new Product("icecream", Category.FROZEN, 125));
        Store s = new Store(products);
        s.addProducts(new Product("bab", Category.OTHER, 100));
        assertEquals(6,products.size());
    }

    @Test
    void getProductByCategoryName() {
        List<Product> products= new ArrayList<>();
        products.add(new Product("alma", Category.OTHER, 125));
        products.add(new Product("kenyér", Category.BAKED_GOODS, 125));
        products.add(new Product("tej", Category.DAIRY, 125));
        products.add(new Product("pizza", Category.FROZEN, 125));
        products.add(new Product("icecream", Category.FROZEN, 125));
        Store s = new Store(products);

        assertEquals(2,s.getProductByCategoryName(Category.FROZEN));

    }

    @Test
    void getProductByCategory() {
        List<Product> products= new ArrayList<>();
        products.add(new Product("alma", Category.OTHER, 125));
        products.add(new Product("kenyér", Category.BAKED_GOODS, 125));
        products.add(new Product("tej", Category.DAIRY, 125));
        products.add(new Product("tejföl", Category.DAIRY, 125));
        products.add(new Product("pizza", Category.FROZEN, 125));
        products.add(new Product("icecream", Category.FROZEN, 125));
        Store s = new Store(products);

        assertEquals("{FROZEN=2, OTHER=1, DAIRY=2, BAKED_GOODS=1}",s.getProductByCategory().toString() );
    }
}