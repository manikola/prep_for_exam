package week05d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void validate() {
        UserValidator uv = new UserValidator();

        User u1 = new User("Aniko", 45);
        User u2 = new User("Oz", 46);
        User u3 = new User("Atilla", -11);
        User u4 = new User("", 45);
        User u5 = new User("Levente", 145);

        List<User> validUsers = List.of(u1,u2);
        List<User> inValidUsers = List.of(u3,u4,u5);

        assertEquals("[Aniko 45, Oz 46]", uv.validate(validUsers).toString());

    }
    @Test
    public void invalidShouldThrowException() throws IllegalArgumentException {
        UserValidator uv = new UserValidator();

        User u1 = new User("Aniko", 45);
        User u2 = new User("Oz", 46);
        User u3 = new User("Atilla", -11);
        User u4 = new User("", 45);
        User u5 = new User("Levente", 145);

        List<User> inValidUsers = List.of(u3,u4,u5);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(inValidUsers));
        assertEquals("Invalid credentials", ex.getMessage());
    }
}