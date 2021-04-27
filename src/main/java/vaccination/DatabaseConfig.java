package vaccination;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class DatabaseConfig {

    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/test?useUnicode=true";
    private static final String DATABASE_USER = "test";
    private static final String DATABASE_PASSWORD = "test";

    public static MariaDbDataSource getConfig() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl(DATABASE_URL);
            dataSource.setUser(DATABASE_USER);
            dataSource.setPassword(DATABASE_PASSWORD);
        } catch (
                SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }
        return dataSource;
    }
}

