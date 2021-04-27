package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product p){
        products.add(p);
        }


    public int getNumberOfExpired(){
        int counter = 0;
        for(Product item : products){
            if(item.getExpiryDate().isBefore(LocalDate.now())){
                counter++;
            }
        }
        return counter;

    }
}
