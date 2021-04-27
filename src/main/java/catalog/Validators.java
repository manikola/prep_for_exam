package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String str){
        return(str == null || str.isBlank());
    }

    public static boolean isEmpty(List  item){
        return(item == null || item.size() == 0);
    }
}

//Validators osztály: Létre kell hozni egy isBlank() és isEmpty() statikus metódust, az egyik egy Stringről
// vizsgálja meg, null vagy üres-e, a másik egy listáról dönti el, hogy null vagy üres-e. Ezeket a metódusokat
// használhatjuk a metódusok paramétereinek ellenőrzésekor.
