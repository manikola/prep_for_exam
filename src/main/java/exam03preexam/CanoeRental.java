package exam03preexam;

import java.time.Duration;
import java.time.LocalDateTime;

public class CanoeRental {

    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum(){
        return Duration.between(startTime, endTime).toHours() * 5000;

    }

    @Override
    public String toString() {
        return  name;
    }
}

//## Kenukölcsönző
//Írj egy olyan CanoeRental osztályt, amely String name, CanoeType canoeType, LocalDateTime startTime, LocalDateTime
 //endTime attribútumokban tárolja egy kenu kölcsönzés
//kölcsönzési adatait.
//A CanoeType egy enum, mely értékei: RED, GREEN és BLUE.
//Publikus metódusok:
//public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime)
//public void setEndTime(LocalDateTime endTime)
//public double calculateRentalSum()
//Minden kölcsönzés aktív, amíg vissza nem hozták a kenut, azaz ki nem töltötték
//az endTime értékét.
//Írj egy CanoeOffice osztályt, mely tárolja, hogy milyen kölcsönzések történtek (List<CanoeRental>).
//A következő metódusokat implementáld:
//* addRental(CanoeRental) - hozzáad egy kölcsönzést
//* findRentalByName(String name) - megkeres egy AKTÍV kölcsönzést név alapján
//* closeRentalByName(String name, LocalDateTime endTime) - megkeres egy AKTÍV kölcsönzést név alapján, beállítja az
// endTime értékét
//* double getRentalPriceByName(String name, LocalDateTime endTime) - kikeresi az AKTÍV kölcsönzést név alapján, és
// kiszámolja, hogy
//a megadott kölcsönzés mennyibe kerülne. A számolás úgy történik, hogy óránként 5000 Ft-ot a szín alapján megszoroz
// egy értékkel, piros,
//zöld és kék esetén rendre 1, 1,2 és 1,5 értékkel. Minden megkezdett óra számít.
//* List<CanoeRental> listClosedRentals() - Add vissza a lezárt kölcsönzéseket a startTime alapján sorbarendezve!
//* Map<CanoeType, Integer> countRentals() - Számold meg, hány kölcsönzés volt színenként! (edited)
//Duration.between(beginDate, endDate).toHours()
