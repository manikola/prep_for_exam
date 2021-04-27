package exam03preexam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class CanoeOfficeTest {

    @Test

            public void addRentalTest() {

        List<CanoeRental> canoeRentals = new ArrayList<>();
        CanoeOffice co = new CanoeOffice(canoeRentals);

        CanoeRental c1 = new CanoeRental("A", CanoeType.RED, LocalDateTime.of(2021, 2, 15, 8, 10));
        CanoeRental c2 = new CanoeRental("B", CanoeType.RED, LocalDateTime.of(2021, 2, 14, 8, 30));
        CanoeRental c3 = new CanoeRental("C", CanoeType.GREEN, LocalDateTime.of(2021, 2, 14, 8, 00));
        CanoeRental c4 = new CanoeRental("D", CanoeType.BLUE, LocalDateTime.of(2021, 2, 15, 9, 00));
        CanoeRental c5 = new CanoeRental("E", CanoeType.BLUE, LocalDateTime.of(2021, 2, 15, 10, 00));

        canoeRentals.add(c1);
        canoeRentals.add(c2);
        canoeRentals.add(c3);
        canoeRentals.add(c4);
        co.addRental(c5);


        assertEquals(5, canoeRentals.size());
        assertEquals("B", co.findRentalByName("B").toString());

        co.closeRentalByName("A",LocalDateTime.of(2021, 2, 15, 9, 00));
        co.closeRentalByName("C",LocalDateTime.of(2021, 2, 15, 9, 00));
        co.closeRentalByName("E",LocalDateTime.of(2021, 2, 15, 12, 00));

        System.out.println(co.listClosedRentals());
        System.out.println(co.countRentals().toString());



    }



}
