package week08d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void getNumbers() {
        Lottery l = new Lottery();
        System.out.println(l.getNumbers());
    }
}