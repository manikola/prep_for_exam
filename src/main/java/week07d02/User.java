package week07d02;

public interface User {

    String getUsername();
    String getFirstName();
    String getLastName();

    default String getFullName() {
        return getFirstName() + " "  + getLastName();
    }

     static User of() {
        User user= null;
        return user;
    }

}
