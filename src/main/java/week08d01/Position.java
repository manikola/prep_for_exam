package week08d01;

public class Position {

    private int x;
    private int y;
    private double distance;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
//    A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot az origóban
//    van. A robot négy irányba képes mozogni fel, le, balra és jobbra. A week08d01.Robot osztályban írj egy move()
//    metódust ami egy karaktersorozatot vár. pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb. A metódus
//    visszatérési értéke legyen a robot mozgás utáni pozíciója. A feladat szabadon bővíthető osztályokkal és metódusokkal.
//    Bónusz kiegészítés, hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét,
//    akkor dobjunk IllegalArgumentExceptiont!