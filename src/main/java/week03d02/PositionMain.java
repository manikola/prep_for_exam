package week03d02;

import java.util.List;

public class PositionMain {

    public static void main(String[] args) {
        Position a = new Position("manager", 500_000);
        Position b = new Position("ceo", 1_000_000);
        Position c = new Position("sales_manager", 250_000);
        Position d = new Position("nobody", 10_000);

        List<Position> company = List.of(a,b,c,d);

        for(Position item : company){
            if(item.getBonus() > 150_000){
                System.out.println(item.toString());
            }
        }
    }
}

//Írj egy Position osztályt, melynek van egy name és egy bonus attribútuma! Egy alkalmazotti pozíciót jelöl, melynek a
// bonus attribútuma tárolja, hogy ebben a pozícióban évente mennyi bónuszt kap egy alkalmazott. A main metódusban hozz
// létre egy Position objektumokat tartalmazo listát!
//
//Menj végig a lista elemein, és írd ki azokat, ahol a bónusz magasabb, mint 150_000. Azonban a kiírás
//formátumát a Position osztály toString() metódusában implementáld!
