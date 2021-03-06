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




//Catalog oszt??ly: A katal??gus tartalmazza a katal??gus elemek list??j??t ??s ebben az oszt??lyban lehet k??l??nb??z?? lek??rdez??seket v??grehajtani. Le lehet k??rdezni:
//
//Az audio illetve nyomtatott jellemz??kkel rendelkez?? elemeket (getAudioLibraryItems(), getPrintedLibraryItems())
//Az ??sszoldalsz??mot a nyomtatottakn??l (getAllPageNumber())
//Az ??sszhosszt az audio t??pus??akn??l (getFullLength())
//Az ??tlag oldalsz??mot egy bizonyos oldalsz??m felett (averagePageNumberOver())
//Keresni lehet egy SearchCriteria alapj??n (l??sd lejjebb) (findByCriteria())