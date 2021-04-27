package week05d04.senior;


public class Product {

    private long price;
    private Currency currency;

    public Product(long price, Currency currency) {
        this.price = price;
//        if (!currency.getName().equals((Currency.USD).toString()) || !currency.getName().equals((Currency.HUF).toString())) {
//            throw new IllegalArgumentException("Wrong currency");
//        }
        this.currency = currency;
    }

    public double convertPrice(Currency c){
        double converted = price;
        if(c == Currency.USD){
            converted = price/300;
        }
        if(c == Currency.HUF){
            converted = price * 300;
        }
        return converted;
    }
}
