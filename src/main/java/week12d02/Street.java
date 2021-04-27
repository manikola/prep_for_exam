package week12d02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Street {

    private List<Site> soldSites = new ArrayList<>();

    public void sellSite(Site site) {
        soldSites.add(site);
    }

    public int getHouseNumberOfLastSold() {
        int counter = 0;
        int hn = 0;
        if (lastSoldIsEven()) {
            for (Site item : soldSites) {
                if (item.getSide().getValue() == 0) {
                    counter++;
                    hn = (counter * 2);
                }
            }
        }if(!lastSoldIsEven()) {
                for (Site item : soldSites) {
                    if(item.getSide().getValue() == 1){
                        counter++;
                        hn = (counter * 2)-1;
                    }
                }
            } return hn;
        }

        public Map<Enum,Integer> makeStatistics(){
            Map<Enum,Integer> results = new HashMap<>();
            for(Site item : soldSites){
                if (!results.containsKey(item.getFenceType())) {
                    results.put(item.getFenceType(), 0);
                }
                results.put(item.getFenceType(), results.get(item.getFenceType()) + 1);
            }
            return results;

        }



    private boolean lastSoldIsEven(){
        return (soldSites.get(soldSites.size()-1).getSide().getValue() == 0);

        }
    }


