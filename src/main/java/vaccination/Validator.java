package vaccination;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static final int MIN_AGE = 10;
    public static final int MAX_AGE = 150;

    public static String validateName(String fullName) {
        if (fullName == null || fullName.isBlank()){
            throw new IllegalArgumentException("Name must be filled");
        }
        return fullName;
    }


    public static int validateAge(int age) {
       if(age >= MIN_AGE && age <= MAX_AGE){
           throw new IllegalArgumentException("Please enter valid age. Eligibility: 10-150");
       }
       return age;
    }

    public static String validateZip(String zipCode) {
        if(zipCode.isBlank() || !(zipCode.trim().length() == 4)){
            throw new IllegalArgumentException("Enter a valid zip");
        }
        return zipCode;
        }



    public static String validateEmail(String email) {
        if (email.trim().length() < 3 || !email.trim().contains("@")){
            throw new IllegalArgumentException("Enter a valid email address");
        }
        return email;
    }


    public static String checkCdvIsValid(String number) {
        if (number.length() < 10 || number.length() > 10) {
            throw new IllegalArgumentException("Enter a valid TAJ number");
        }
        boolean b = false;
        int sum = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            numbers.add(Integer.parseInt(number.substring(i, i + 1)));
        }
        for (int i = 0; i < 9; i++) {
            sum = sum + numbers.get(i) * (i + 1);
        }
        if (sum % 11 != numbers.get(9)) {
            throw new IllegalArgumentException("Enter a valid TAJ number");

        }
        return number;

    }



}

//Amikor regisztrálja magát, a következőket kell megvalósítani:
//------ Ellenőrizzük, a név nem lehet üres
//Ha beírja az irányítószámát, akkor írjuk ki a hozzá tartozó települést
//------ Ha az irányítószám üres, hibaüzenetet kell kiírni
//------ Az életkor > 10 és < 150.
//Az e-mail cím legyen formaliag helyes, elegendő, ha legalább 3 karakter, és van benne egy @ karakter
//Az e-mail címét kétszer kell megadni, és másodjára is ugyanazt a címet kell megadni
//------ A TAJ számot CDV ellenőrzésnek kell alávetni