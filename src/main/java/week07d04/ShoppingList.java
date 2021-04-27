package week07d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShoppingList {

    public long calculateSum(String filename){
        long sum = 0;
      Path path = Path.of("src/main/resources/" + filename);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while((line = br.readLine()) != null){
                String[] arr = line.split(";");
                long amount = Long.parseLong(arr[1]);
                long price = Long.parseLong(arr[2]);
                sum += (amount * price);

            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file",e);
        }
        return sum;

    }
}
//A ShoppingList osztályba írj egy long calculateSum(String path) metódust, mely a paraméterként átadott fájlból
// beolvassa a bevásárlólista tartalmát, és összegzi az árat! A fájl a következő formátumú sorokat tartalmazza:
// kenyér;2;30, ahol az első a termék neve, a második a darabszám, a harmadik az egységár. Azaz ezen sor
// esetén 2 * 30 = 60 értékkel kell számolni.