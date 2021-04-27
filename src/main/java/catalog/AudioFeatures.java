package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{

    private List<String> composer = new ArrayList<>();
    private final int length;
    private List<String> performers= new ArrayList<>();
    private final String title;

    public AudioFeatures(String title,  int length, List<String> performers, List<String> composer) {
        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
        if(length < 0){
            throw new IllegalArgumentException("Length must be positive");
        }
        this.length = length;
        if(Validators.isEmpty(performers)){
            throw new IllegalArgumentException("Performer cannot be empty");
        }
        this.performers = performers;
        this.composer = composer;

    }

    public AudioFeatures(String title, int length, List<String> performers) {
        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
        if(length < 0){
            throw new IllegalArgumentException("Length must be positive");
        }
        this.length = length;
        if(Validators.isEmpty(performers)){
            throw new IllegalArgumentException("Performer cannot be empty");
        }
        this.performers = performers;

    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> containsBoth = new ArrayList<>();
        for(String item: composer){
            containsBoth.add(item);
        }
        for(String item : performers){
            containsBoth.add(item);
        }
        return containsBoth;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
//AudioFeatures osztály: Ez az osztály jellemez egy katalóguselemet, ha az audio tulajdonságokkal rendelkezik.
// Ilyen a zenei album és hangoskönyv. Minden audio elemnek van címe, hossza, előadói, illetve szerzői.
// Implementálja a Feature interface-t. A szerzők megadása nem kötelező (két konstruktor szükséges, overload).
// A getContributors() metódus a szerzők és előadók közös listájával tér vissza.