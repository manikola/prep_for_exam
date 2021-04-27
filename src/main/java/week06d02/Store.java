package week06d02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private List<Product> productList= new ArrayList<>();

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }

    public void addProducts(Product p){
        productList.add(p);
    }

    public int getProductByCategoryName(Category c){
        int counter = 0;
        for(Product item : productList){
            if(item.getCategory() == c){
                counter++;
            }
        }
        return counter;
    }
    public Map<Category, Integer> getProductByCategory(){
        Map<Category, Integer> results = new HashMap<>();
        for(Product item : productList){
            if(!results.containsKey(item.getCategory())){
                results.put(item.getCategory(), 0);
            }
                results.put(item.getCategory(),results.get(item.getCategory()) + 1);
            }

        return results;


    }


}
