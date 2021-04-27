package vaccination;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitizenDaoTest {

    private CitizenDao citizenDao;

    @BeforeEach
    void setUp() {
        DataSource config = new DatabaseConfig().getConfig();

       Flyway flyway = Flyway.configure().dataSource(config).load();
//        flyway.clean();
       flyway.migrate();

        citizenDao = new CitizenDao(config);
    }

    @Test
    public void findSettlementsByZipCode(){

        assertEquals("[Győr*]",citizenDao.findSettlementsByZipCode("9000").toString());

    }

    @Test
    void insertCitizenTest() {
        Citizen citizen1 = new Citizen("John Doe", "2063", 60, "john.doe@example.com", "8365670003");
        Citizen citizen2 = new Citizen("Jane Doe", "2091", 40, "jane.doe@example.com", "8365670003");

        assertEquals(2,citizenDao.insertCitizenToDb(citizen1));
        assertEquals(2,citizenDao.insertCitizenToDb(citizen2));

    }

    @Test
    void createCitizenFromFileTest(){
        citizenDao.createCitizenListFromFile("/citizens.csv");
    }

    @Test
    void insertCitizensFromList(){
        Citizen c1 = new Citizen("Karry Kropach","6165",44, "kkropachg@istockphoto.com","8365670003");
        Citizen c2 = new Citizen("Fawn Monkeman","8388",46, "fmonkemanh@unblog.fr","8365670003");
        Citizen c3 = new Citizen("Haywood Swait","3392",24, "hswaiti@constantcontact.com","8365670003");
        List<Citizen> testList = List.of(c1,c2,c3);





    }
}
