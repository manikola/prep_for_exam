package week06d05;

public class Bottle {

    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type, int filledUntil) {
        this.type = type;
        this.filledUntil = filledUntil;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }
    public static Bottle of(BottleType t, int f){
        return new Bottle(t, f);
    }

    public Bottle fill(int fillAmount){
        if( (getType().getMaximumAmount() - filledUntil) > fillAmount){
            return of(this.getType(), this.filledUntil+fillAmount);
        }
        throw new IllegalArgumentException("too much to fill");
    }
}

//Készíts egy Bottle nevű osztályt, amelynek van 2 attribútuma: BottleType type és int filledUntil. A BottleType
// legyen felsorolásos típus az alábbi értékekkel: GLASS_BOTTLE és PET_BOTTLE! A Bottle nevű osztálynak legyen egy
// static metódusa of néven, mely paraméterként egy BottleType-ot vár és visszaad egy új Bottle objektumot amelyet a
// megadott paraméter alapján hoz létre. A Bottle osztálynak legyen egy fill metódusa, mely egy int fillAmount paramétert
// vár. A fill meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a Bottle objektum. Az ehhez szükséges int
// maximumAmount mezőt a BottleType tartalmazza! Ha túlcsordulna a Bottle objektum, akkor dobj kivételt!
