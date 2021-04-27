package week07d02;

public class DigitSum {

    public static int sumOfDigits(int x){
        int sum = 0;
        while (x != 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        return sum;

    }
}
