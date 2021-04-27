package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();
    private final List<Integer> daysOfWeek = List.of(1,2,3,4,5,6,7);

    public Courier(List<Ride> rides) {
        this.rides = rides;
    }
    public Courier(){

    }

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        if (ride.getDay() < rides.get(rides.size() - 3).getDay()) {
            throw new IllegalArgumentException("Invalid day");
        }
        if (ride.getSerialNumber() < rides.get(rides.size() - 2).getSerialNumber()) {
            throw new IllegalArgumentException("Invalid fuvar");
        }
        rides.add(ride);
    }

    public List<Integer> dayOff(){
        List<Integer> daysWhenWorked = new ArrayList<>();
        List<Integer> daysWhenOff = new ArrayList<>();
        for(int i=0; i< rides.size();i= i+2){
            daysWhenWorked.add(i);
            for(Integer item: daysOfWeek){
                if(!daysWhenWorked.contains(item)){
                    daysWhenOff.add(item);
                }
            }
        } return daysWhenOff;
    }


}

//A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.
//
//       A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott
//       nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy
//       fuvarját reprezentálja a Ride nevű osztály, adatagokkal, konstruktorra, getterekkel.
//
//       Készítsd el a Courier osztályt. Ez fogja a futárt reprezentálni. Legyen egy rides listája ami fuvarokat tárol.
//       Legyen egy addRide metódus, ami csak sorrendben enged hozzáadni elemeket a listához. Figyeljünk viszont arra,
//       hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar, akkor ne kerülhessen
//       be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok. Ha a paraméterül
//       kapott Ride nem felel meg a feltételeknek dobjunk IllegalArgumentException-t.
//
//   pl egy helyes listára: 1 1 12 1 2 11 2 1 10 4 1 19
//
//  Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha több ilyen nap is van akkor a korábbit!