package employees;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertEmployee(String name){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `employees`(emp_name) VALUES (?);")) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Error by insert", se);
        }
    }

    public String selectEmployeeById(long l){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `emp_name` FROM `employees` WHERE `id` =?;");) {
            stmt.setLong(1, l);

            return getStringByPreparedStatement(stmt);


        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by select", se);
        }

    }

    private String getStringByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("emp_name");
                return name;
            }
            throw new IllegalArgumentException("No results");
        } catch (SQLException se) {
            throw new IllegalStateException("Error by select", se);

        }
    }

    public List<String> getAllNamesBeforeId(long id){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `emp_name` FROM `employees` WHERE `id` <= ?;")) {
            stmt.setLong(1, id);


            return extracted(stmt);

        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by select", se);
        }
    }

    private List<String> extracted(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);

            }
            return names;


        } catch (SQLException se) {
            throw new IllegalStateException("Error by select", se);

        }
    }
}
