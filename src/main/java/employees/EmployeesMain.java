package employees;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create datasource", se);
        }

        EmployeesDao dao = new EmployeesDao(dataSource);
       // dao.insertEmployee("Kakukktojás");
        System.out.println(dao.getAllNamesBeforeId(5));
        System.out.println(dao.selectEmployeeById(5));





    }
}
