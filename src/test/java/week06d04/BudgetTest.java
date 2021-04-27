package week06d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    @Test
    void getItemsByMonth() {
        Item i1 = new Item(111,12,"alma");
        Item i2 = new Item(111,11,"banán");
        Item i3 = new Item(111,12,"narancs");
        Item i4 = new Item(111,12,"körte");

        Budget b = new Budget(List.of(i1,i2,i3,i4));

        assertEquals("[alma, narancs, körte]", b.getItemsByMonth(12).toString());
    }
}