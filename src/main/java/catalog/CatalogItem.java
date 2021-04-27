package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private String registrationNumber;
    private int price;
    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature...features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(features));
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int numberOfPagesAtOneItem() {
        int sum = 0;
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) item).getNumberOfPages();
            }
        }
        return sum;
    }

    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                sum += ((AudioFeatures) item).getLength();
            }
        }
        return sum;
    }

    public List<String> getTitles(){
        List<String> titleList = new ArrayList<>();
        for(Feature item : features){
            titleList.add(item.getTitle());
        }
        return titleList;

    }

    public List<String> getContributors(){
        List<String> contributorList = new ArrayList<>();
        for(Feature item : features){
            contributorList.addAll(item.getContributors());
        }
        return contributorList;

    }

    public boolean hasPrintedFeature() {
              for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }
}
//CatalogItem osztály: Minden katalógus elemnek van egy jellemzők listája melyek lehetnek akár nyomtatottak vagy audio-k.
// Továbbá minden katalógus elemnek van ára és egy regisztrációs száma.
