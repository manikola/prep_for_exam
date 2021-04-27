package week05d03;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public List<User> validate(List<User> toBeValidated){
        if(toBeValidated.size() == 0){
            throw new IllegalArgumentException("List is empty");
        }
        List<User> validated = new ArrayList<>();
        for(User item : toBeValidated){
            if( item == null || item.getName() == null || item.getName().isBlank()
                    || item.getAge() < 0 ||item.getAge() > 120){
                throw new IllegalArgumentException("Invalid credentials");
            }
            else{
                validated.add(item);
            }
        }
        return validated;


    }


}
//A UserValidator osztályba írj egy validate(List<User>) metódust, mely leellenőrzi a paraméterben átadott
// felhasználókat! (A User egy String name és egy int age attribútumot tartalmazzon!) Ha a lista null, dobjon kivételt!
// Ha a felhasználó null, dobjon kivételt! Ha A felhasználó neve null, vagy üres, dobjon kivételt! Ha az életkor kisebb
// mint 0, vagy nagyobb, mint 120, dobjon kivételt!