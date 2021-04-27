package vaccination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CitizenTest {

    @Test
    public void emptyNameShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Citizen("","9029",27,"aaa@bbb","8365670003"));
        assertEquals("Name must be filled", ex.getMessage());
    }
    @Test
    public void blankNameShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Citizen("  ","9029",27,"aaa@bbb","8365670003"));
        assertEquals("Name must be filled", ex.getMessage());
    }
    @Test
    public void underAgeShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Citizen("gyerek","9029",9,"aaa@bbb","8365670003"));
        assertEquals("Please enter valid age. Eligibility: 10-150", ex.getMessage());
    }
    @Test
    public void invalidZipShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Citizen("Valaki","99999",27,"aaa@bbb","8365670003"));
        assertEquals("Enter a valid zip", ex.getMessage());
    }
    @Test
    public void invalidCdvShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Citizen("Valaki","9023",27,"aaa@bbb","836567000004"));
        assertEquals("Enter a valid TAJ number", ex.getMessage());
    }
}
