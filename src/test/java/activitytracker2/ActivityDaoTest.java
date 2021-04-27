package activitytracker2;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao dao;

    MariaDbDataSource dataSource;

    @BeforeEach
    public void init(){
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker2?useUnicode=true");
            dataSource.setUser("activitytracker2");
            dataSource.setPassword("activitytracker2");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }

        Flyway flyway = Flyway.configure().locations("/db/migration/activity_tracker").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();


        dao = new ActivityDao(dataSource);
    }

    @Test
    void insertActivity() {
        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 1, 12, 15), "Futás Bakonyban", Type.HIKING);
        dao.insertActivity(activity1);

    }

    @Test
    void findActivityById() {
        assertEquals("Biking in Bükk",dao.findActivityById(2).getDesc());
    }

    @Test
    void selectAllActivities() {
        assertEquals(4, dao.selectAllActivities().size());

    }

    @Test
    void insertActivityAndGetGeneratedKey() {
      assertEquals(5, (dao.insertActivityAndGetGeneratedKey(new Activity(LocalDateTime.of(
              2021, 2, 1, 12, 15), "Futás Bakonyban", Type.HIKING))).getId());
    }

}