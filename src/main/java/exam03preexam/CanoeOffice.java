package exam03preexam;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {

    private List<CanoeRental> canoeRentals = new ArrayList<>();

    public CanoeOffice(List<CanoeRental> canoeRentals) {
        this.canoeRentals = canoeRentals;
    }

    public void addRental(CanoeRental cr){
        canoeRentals.add(cr);
    }

    public CanoeRental findRentalByName(String name){
        CanoeRental searched = null;
        for(CanoeRental item : canoeRentals){
            if(item.getName().equals(name)  && isActive(item)){
                searched = item;
            }
        }if( searched ==null) {
            throw new IllegalArgumentException("Canoerental" + name + "doesn't exist");
        }
        return searched;
    }

    public void closeRentalByName(String name, LocalDateTime endTime){
        CanoeRental cr = findRentalByName(name);
        cr.setEndTime(endTime);

    }

    double getRentalPriceByName(String name, LocalDateTime endTime){
        CanoeRental cr = findRentalByName(name);
        return cr.calculateRentalSum() * cr.getCanoeType().getValue();
    }

    private boolean isActive(CanoeRental cr){
        return cr.getEndTime() == null;
    }

    public List<CanoeRental> listClosedRentals(){
        List<CanoeRental> closedItems = new ArrayList<>();
        for( CanoeRental item : canoeRentals){
            if(!isActive(item)){
                closedItems.add(item);
            }
        }
        closedItems.sort(Comparator.comparing(CanoeRental::getStartTime));
        return closedItems;
    }

    public Map<CanoeType,Integer> countRentals(){
        Map<CanoeType,Integer> results = new HashMap<>();
        for(CanoeRental item : canoeRentals){
            if (!results.containsKey(item.getCanoeType())) {
                results.put(item.getCanoeType(), 0);
            }
                results.put(item.getCanoeType(), results.get(item.getCanoeType()) + 1);
            }
        return results;

        }

    }


