package activitytracker2;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO `activities`(start_time,activity_desc,activity_type) VALUES(?,?,?);");) {
            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().toString());
            ps.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }

    }





    public Activity findActivityById(long id) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?;")) {
            ps.setLong(1, id);
            List<Activity> result = selectActivityByPreparedStatement(ps);
            if (result.size() == 1) {
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found");


        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }

    }
    private List<Activity> selectActivityByPreparedStatement(PreparedStatement ps) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Activity a = new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        Type.valueOf(rs.getString("activity_type")));
                result.add(a);

            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

    }

    public List<Activity> selectAllActivities() {
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM `activities`;")) {

            result = selectActivityByPreparedStatement(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }
        return result;

    }

    public Activity insertActivityAndGetGeneratedKey(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO `activities`(start_time,activity_desc,activity_type) VALUES(?,?,?);",Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().toString());
            ps.executeUpdate();
            long id = executeAndGetGeneratedKey(ps);
            return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());


        } catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }

    }

    private long executeAndGetGeneratedKey(PreparedStatement ps) {
        try(ResultSet rs = ps.getGeneratedKeys()) {
            if(rs.next()){
                return rs.getLong(1);
            }
            else{
                throw new SQLException("No key generated");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }
    }
}
