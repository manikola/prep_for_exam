package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int number = rnd.nextInt(101);
        int answer = 0;


            System.out.println("Enter a number");

        int i = 0;
        while (answer != number && i < 6) {
            answer = Integer.parseInt(scanner.nextLine());
            if (answer == number) {
                System.out.println("Well done,you've guessed it right!");
                break;
            } else if (answer > number) {
                System.out.println("Enter smaller number:");
            } else if (answer < number) {
                System.out.println("Enter larger number:");
            }
            i++;
        }
        if (answer != number) {
            System.out.println("Nincs több válaszlehetőség, a keresett szám a " + number + " volt.");
        }

    }
}
//Írj egy számkitaláló programot a GuessTheNumber osztályba! A program kitalál egy véletlenszerű számot 1 és 100 között.
// Majd bekér a felhasználótól ciklusban számokat. Mindig megmondja, hogy a szám, kisebb, nagyobb vagy egyenlő-e mint
// a gondolt szám.
//
//Bónusz feladat: max 6-szor lehet kérdezni!