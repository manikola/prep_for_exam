package exam02;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }

    public void addPhoto(String... names) {
        for (String item : names) {
            photos.add(new Photo(item));
        }
    }

    public void starPhoto(String name, Quality q){
        boolean found = false;
        for(Photo item : photos) {
            if (item.getName().equals(name)) {
                item.setQuality(q);
                found = true;
            }
        }
            if(!found){
                throw new PhotoNotFoundException("No photo");
            }
        }



    public int numberOfStars(){
        int sum = 0;
        for(Photo item :photos){
            sum += item.getQuality().getValue();
        }return sum;
    }
}

//Írj egy PhotoCollection osztályt, mely a fotók egy listáját tartalmazza! Fotókat lehet hozzáadni névvel, ekkor még
// nem kapnak csillagot. Az addPhoto() metódus legyen varargs-os!
//
//Írj egy starPhoto() metódust, mely kikeresi a megfelelő nevű fotót, és beállítja rajta a paraméterként átadott
// minősítést! Ha nem talál a megadott névvel fotót, PhotoNotFoundException kivételt dob. Ez egy saját kivétel,
// terjessze ki a RuntimeException osztályt!
//
//Írj egy numberOfStars() metódust, mely visszaadja, hogy a képeken összesen mennyi csillag van! Ha nincs minősítése,
// akkor 0 csillag. Ha a minősítése Quality.ONE_STAR, akkor egy csillaggal kell számolni.
// Ha a minősítése Quality.TWO_STAR, akkor két csillaggal kell számolni.
//
//Tartsd be az elnevezési konvenciókat! A megoldásban csak foreach-eket használj!

