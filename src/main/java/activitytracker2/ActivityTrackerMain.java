package activitytracker2;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker2?useUnicode=true");
            dataSource.setUser("activitytracker2");
            dataSource.setPassword("activitytracker2");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }


        ActivityDao dao = new ActivityDao(dataSource);

    }

}

