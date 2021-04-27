package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem item) {
        catalogItems.add(item);
    }

    public void deleteItemByRegistrationNumber(String regNr) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(regNr)) {
                catalogItems.remove(catalogItems.get(i));
            }
        }
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                audioItems.add(item);
            }
        }
        return audioItems;

    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                printedItems.add(item);
            }
        }
        return printedItems;

    }

    public double averagePageNumberOver(int numberOfPages) {
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        List<Integer> numberOfPagesList = new ArrayList<>();
        for (CatalogItem item : getPrintedLibraryItems()) {
            if (item.numberOfPagesAtOneItem() > numberOfPages) {
                numberOfPagesList.add(item.numberOfPagesAtOneItem());
            }
        }

        if (Validators.isEmpty(numberOfPagesList)) {
            throw new IllegalArgumentException("No page");
        }

        int sum = 0;
        for (Integer i : numberOfPagesList) {
            sum += i;
        }
        return (sum / numberOfPagesList.size()) * 1.0;
    }


    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem item : catalogItems) {
            sum += item.numberOfPagesAtOneItem();
        }
        return sum;

    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem item : catalogItems) {
            sum += item.fullLengthAtOneItem();
        }
        return sum;

    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> results = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (searchCriteria.hasTitle()) {
                for (String str : item.getTitles()) {
                    if (searchCriteria.getTitle().equals(str)) {
                        results.add(item);
                    }
                }

            } else if (!searchCriteria.hasTitle() && searchCriteria.hasContributor()) {
                for (String string : item.getContributors()) {
                    if (searchCriteria.getContributor().equals(string)) {
                        results.add(item);
                    }
                }
            }
        }
        return results;
    }
}




//Catalog osztály: A katalógus tartalmazza a katalógus elemek listáját és ebben az osztályban lehet különböző lekérdezéseket végrehajtani. Le lehet kérdezni:
//
//Az audio illetve nyomtatott jellemzőkkel rendelkező elemeket (getAudioLibraryItems(), getPrintedLibraryItems())
//Az összoldalszámot a nyomtatottaknál (getAllPageNumber())
//Az összhosszt az audio típusúaknál (getFullLength())
//Az átlag oldalszámot egy bizonyos oldalszám felett (averagePageNumberOver())
//Keresni lehet egy SearchCriteria alapján (lásd lejjebb) (findByCriteria())