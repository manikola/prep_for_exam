package vaccination;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDao {

    private DataSource dataSource;

    public CitizenDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> findSettlementsByZipCode(String zipCode) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `settlement` FROM `cities` WHERE zip = ? ORDER BY `settlement`;")) {

            stmt.setString(1, zipCode);
            List<String> result = selectSettlementByPreparedStatement(stmt);
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }
    }

    private List<String> selectSettlementByPreparedStatement(PreparedStatement stmt) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("settlement"));

            }
            return result;

        } catch (SQLException se) {
            throw new IllegalArgumentException("Execute failed", se);
        }

    }

    public long insertCitizenToDb(Citizen citizen) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO `citizens` (`citizen_name`,`zip`,`age`,`email`,`taj`) VALUES (?,?,?,?,?);",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, citizen.getFullName());
            stmt.setString(2, citizen.getZipCode());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getTAJ());
            stmt.executeUpdate();
            return executeAndGetGenerateKey(stmt);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by insert", se);
        }

    }

    private long executeAndGetGenerateKey(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.getGeneratedKeys();
        ) {
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key has generated");
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Erroe by inser", se);
        }
    }

    public List<Citizen> createCitizenListFromFile(String fileName) {
        List<Citizen> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CitizenDao.class.getResourceAsStream(fileName)))) {
            String columns = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                Citizen citizen = new Citizen(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], arr[4]);
                result.add(citizen);


            }


        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
        return result;
    }

    public void insertCitizensFromList(List<Citizen> citizens) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `citizens` (`citizen_name`,`zip`,`age`,`email`,`taj`) VALUES (?,?,?,?,?);")) {
            for (Citizen c : citizens) {
                setStmt(c, stmt);
                stmt.executeUpdate();
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert values.", sqle);
        }
    }

    private void setStmt(Citizen c, PreparedStatement stmt)throws SQLException {
        stmt.setString(1, c.getFullName());
        stmt.setString(2, c.getZipCode());
        stmt.setInt(3, c.getAge());
        stmt.setString(4, c.getEmail());
        stmt.setString(5, c.getTAJ());
    }


    private List<Long> executeAndGetGeneratedKeys(PreparedStatement stmt) {
        List<Long> result = new ArrayList<>();
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            while (rs.next()) {
                result.add(rs.getLong(1));
            }
            return result;
            //throw new SQLException("No key was generated.");
        } catch (SQLException e) {
            throw new IllegalArgumentException("Insertion failed.", e);
        }
    }


}