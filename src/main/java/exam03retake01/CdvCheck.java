package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class CdvCheck {

    public boolean check(String number) {
        if (number.length() < 10 || number.length() > 10) {
            throw new IllegalArgumentException("Not valid tax number");
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
        if (sum % 11 == numbers.get(9)) {
            b = true;

        }
        return b;

    }
}

//Írj egy CdvCheck.check() metódust (paraméterezése, visszatérési értéke kiderül a tesztesetből), mely kap egy adószámot,
// és eldönti róla, hogy helyes-e! A következőképp kell eldönteni. Fogni kell az első kilenc számjegyet, és megszorozni
// rendre 1, 2, ..., 9 számmal. Az eredményt kell összegezni, majd maradékos osztani 11-el. A 10. számjegynek meg kell
// egyeznie ezzel a számmal (maradékkal).
//
//Pl.:
//
//8365670003
//1 * 8 + 2 * 3 + 3 * 6 + ... + 9 * 0 = 124
//124 maradékos osztás 11-el = 3
//3 (maradék) == 3 (10. számhegy) - az adószám megfelelő
//Ha a paraméterként átadott adószám nem 10 számjegy, vagy nem csak számjegy szerepel benne, IllegalArgumentException
// kivételt kell dobni.
