package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Airport {

    private List<Flight> flights = new ArrayList<>();


    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public void readFromFile(BufferedReader br){
        try  {
            String line;
            while((line = br.readLine()) != null){
                String[] arr = line.split(" ");
                String[]time = arr[3].split(":");
                int hour = Integer.parseInt(time[0]);
                int min = Integer.parseInt(time[1]);
                flights.add(new Flight(arr[0],Direction.valueOf(arr[1].toUpperCase()),arr[2], LocalTime.of(hour,min)));


            }

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file",e);
        }
    }
    public Direction whatsMore(){
        int countArr = 0;
        int countDep = 0;
        for(Flight item : flights) {
        if(item.getDirection() == Direction.ARRIVAL){
            countArr++;
        } else {
                countDep++;
            }
        }
        if(countArr >= countDep){
            return Direction.ARRIVAL;
        }
        return Direction.DEPARTURE;
    }

    public Flight searchFlight(String flightNumber){
        for(Flight item :flights){
            if( item.getFlightNumber().equals(flightNumber)){
                return item;
            }
        }
        throw new IllegalArgumentException("Can not find flight");
    }

    public List<Flight> getAllFlightsForCity(String city, Direction dir){
        List<Flight> results = new ArrayList<>();
        for(Flight item : flights){
            if(item.getCity().equals(city) && item.getDirection().equals(dir)){
                results.add(item);
            }
        }
        return results;
    }
    public Flight earliestDeparture(){
        LocalTime time = LocalTime.of(23,59);
        Flight earliest = flights.get(0);
        for(Flight item : flights){
            if(item.getDirection() == Direction.DEPARTURE && item.getTime().isBefore(time)){
                time = item.getTime();
                earliest = item;

            }
        }
        return earliest;

    }





    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(Flight.class.getResourceAsStream("/timetable.txt")))) {
            Airport a = new Airport();
            a.readFromFile(br);

            System.out.println(a.whatsMore());
            System.out.println(a.searchFlight("EJ9251"));
            System.out.println(a.getAllFlightsForCity("Amsterdam", Direction.ARRIVAL));
            System.out.println(a.earliestDeparture());


        }catch (IOException e) {
            throw new IllegalStateException("Can not find file",e);
        }
    }
}
//Adott egy f??jl melyben egy rept??r egy napi munk??j??t r??gz??tett??k. Adott egy j??ratsz??m, az, hogy ??rkez?? vagy felsz??ll??
// g??pr??l van-e sz??. A kiindul??/c??l v??ros, att??l f??gg??en hogy indul vagy ??rkezik-e a g??p ??s a felsz??ll??s/lesz??ll??s
// pontos ideje.
//
//A f??jl:
//
//FC5354 Arrival Dublin 18:16
//KH2442 Departure Berlin 15:54
//ID4963 Departure Amsterdam 15:22
//CX8486 Arrival Brussels 10:37
//EJ9251 Departure  Toronto 11:30
//KJ7245 Departure Bern 6:18
//JN6048 Arrival Moscow 18:39
//MN5047 Arrival Athens 9:35
//Az id??pontok sz??nd??kosan ??gy szereplnek, nincsenek null??k a sz??mok el??tt. Az adatok ??ssze vissza szerepelnek a
// f??jlban. Feladatok:
//
//Olvasd be a f??jl tartalm??t a mem??ri??ba.
//Hat??rozd meg, hogy indul?? vagy ??rkez?? j??ratb??l volt-e t??bb.
//Legyen egy met??dus ami j??ratsz??m alapj??n ad vissza egy j??ratot.
//??rj egy met??dust ami bek??r egy v??rost ??s azt, hogy az indul?? vagy ??rkez?? j??ratokat szeretn??nk-e. ??s egy List??ba
// adjuk viassza az ??sszes abba v??rosba indul??/??rkez?? rep??l??t.
//Adjuk vissza a legkor??bban indul?? rep??l??t! F??jl: examples\week13d02\src\main\resources\cities.txt