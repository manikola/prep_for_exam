package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {

        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(new Passenger(passenger.getName(), passenger.getCruiseClass()));
        } else {
            throw new IllegalArgumentException("Boat full");
        }
    }

    public double getPriceForPassenger(Passenger passenger){
        return passenger.getCruiseClass().getMultiplier() * getBasicPrice();
    }

    public Passenger findPassengerByName(String name){
        for(Passenger item : passengers){
            if(item.getName().equals(name)){
                return item;
            }
        }
       throw new IllegalArgumentException("Not found with name: " + name);
  }


    public List<String> getPassengerNamesOrdered(){
        List<String> namesInOrder = new ArrayList<>();
        for(Passenger item : passengers){
            namesInOrder.add(item.getName());
        }
        Collections.sort(namesInOrder, Collator.getInstance(new Locale("hu", "HU")));
        return namesInOrder;
    }

    public double sumAllBookingsCharged(){
        double sum = 0.0;
        for(Passenger item :passengers){
            sum += getPriceForPassenger(item);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass(){
        Map<CruiseClass, Integer> results = new HashMap<>();
        for(Passenger item : passengers){
            if(!results.containsKey(item.getCruiseClass())){
                results.put(item.getCruiseClass(), 0);
            }
            results.put(item.getCruiseClass(), results.get(item.getCruiseClass()) + 1);
        }
        return results;
    }
}

