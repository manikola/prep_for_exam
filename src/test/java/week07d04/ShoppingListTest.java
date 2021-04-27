package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    void calculateSum() {
        ShoppingList sl = new ShoppingList();


        assertEquals(750, sl.calculateSum("shopping_list.txt"));
    }
}