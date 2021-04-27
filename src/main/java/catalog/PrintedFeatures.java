package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{

    private String title;
    private int numberOfPages;
    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;
        if(numberOfPages < 0){
            throw new IllegalArgumentException("NumberOfPages must be positive");
        }
        this.numberOfPages = numberOfPages;
        if(Validators.isEmpty(authors)){
            throw new IllegalArgumentException("Author can not be empty");
        }
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}

//PrintedFeatures osztály: Ez az osztály jellemez egy katalóguselemet, ha az nyomtatott tulajdonságokkal rendelkezik.
// A nyomtatott jellemzők a cím, az oldalszám, illetve a szerzők. Szintén a Feature-t implementálja.
// A getContributors() itt a szerzőket adja vissza listaként.
