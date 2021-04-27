package week12d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreetTest {

    @Test
    void getHouseNumberEvenTest() {
        Street street = new Street();
        street.sellSite(new Site(Side.EVEN, 10, FenceType.PERFECT));
        street.sellSite(new Site(Side.EVEN, 7, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(Side.ODD, 12, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(Side.EVEN, 9, FenceType.PERFECT));
        street.sellSite(new Site(Side.EVEN, 11, FenceType.NO_FENCE));
        street.sellSite(new Site(Side.ODD, 13, FenceType.PERFECT));
        street.sellSite(new Site(Side.EVEN, 13, FenceType.PERFECT));

        assertEquals(10, street.getHouseNumberOfLastSold());
    }

    @Test
    void getHouseNumberOddTest() {
        Street street = new Street();
        street.sellSite(new Site(Side.EVEN, 10, FenceType.PERFECT));
        street.sellSite(new Site(Side.ODD, 7, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(Side.ODD, 12, FenceType.NEED_UPGRADE));

        assertEquals(3, street.getHouseNumberOfLastSold());
    }

    @Test
    void makeStatisticsTest() {

        Street street = new Street();

        street.sellSite(new Site(Side.EVEN, 10, FenceType.PERFECT));
        street.sellSite(new Site(Side.EVEN, 7, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(Side.ODD, 12, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(Side.EVEN, 9, FenceType.PERFECT));
        street.sellSite(new Site(Side.EVEN, 11, FenceType.NO_FENCE));
        street.sellSite(new Site(Side.ODD, 13, FenceType.PERFECT));
        street.sellSite(new Site(Side.EVEN, 13, FenceType.PERFECT));

        System.out.println(street.makeStatistics());
    }



}
