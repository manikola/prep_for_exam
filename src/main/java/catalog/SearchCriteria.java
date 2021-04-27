package catalog;

public class SearchCriteria {

    private final String contributor;
    private final String title;

    private SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;

    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
    public boolean hasTitle(){
        return(!Validators.isBlank(title));
    }
    public boolean hasContributor(){
        return(!Validators.isBlank(contributor));
    }

    public static SearchCriteria createByBoth(String contributor,String title){
        if(Validators.isBlank(contributor) || Validators.isBlank(title)){
            throw new IllegalArgumentException("Title and contributor can not be empty");
        }
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor){
        if(Validators.isBlank(contributor)){
            throw new IllegalArgumentException("Contributor can not be empty");
        }
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByTitle(String title){
        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Title can not be empty");
        }
        return new SearchCriteria(title, null);
    }
}
//SearchCriteria osztály: Egy immutable osztály melynek attribútumai egy cím és egy szerző. Az osztályt úgy kell
// megvalósítani, hogy akár cím, akár szerző alapján, sőt mindkettő alapján lehessen keresni a katalógusban
// (statikus metódusokkal lehet létrehozni).
