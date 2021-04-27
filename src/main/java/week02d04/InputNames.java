package week02d04;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 5 names: ");

        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            String name = scanner.nextLine();
            arr[i] = name;
        }

        for (String item : arr) {
            System.out.println(item);
        }
    }
}

//Hozz létre egy InputNames Java osztályt, melynek van egy main metódusa. Ciklusban kérj be öt nevet! A neveket tárold
// el egy tömbben! Írd ki a tömb tartalmát, sortöréssel elválasztva (írd bele, hogy hanyadik elem - 1-től sorszámozva)!
