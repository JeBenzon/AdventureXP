package adventurexp.demo.repository;

import adventurexp.demo.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class ActivityRepositoryImpl implements ActivityRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int createActivity(Activity activity) {
        return jdbcTemplate.update(

                "INSERT INTO activities(ageLimit,price,participant,instructor,name,date,max,min) VALUES (?,?,?,?,?,?,?,?)",
                activity.getAgeLimit(),activity.getPrice(), activity.getParticipants(),activity.getInstructor(), activity.getName(),activity.getDate(),activity.getMaxSlots(), activity.getMinSlots()
        );
    }

    @Override
    public int deleteActivity(int id) {
        return jdbcTemplate.update(
                "DELETE FROM activities where id = ?", id
        );
    }

    @Override
    public int updateActivity(Activity activity) {
        return jdbcTemplate.update(
                "UPDATE activities SET ageLimit = ?, price = ?,participant = ?,instructor = ?,name = ?,date = ?,max = ?, min = ?, where id = ?",
                activity.getAgeLimit(),activity.getPrice(), activity.getParticipants(),activity.getInstructor(), activity.getName(),activity.getDate(),activity.getMaxSlots(), activity.getMinSlots(), activity.getActitivtyId()

        );
    }

    @Override
    public Activity getActivity(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM activities where id = " + id,
                (resultSet, rowNum) ->
                        new Activity(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("ageLimit"),
                                resultSet.getDouble("price"),
                                resultSet.getInt("participant"),
                                resultSet.getInt("min"),
                                resultSet.getInt("max"),
                                resultSet.getString("instructor"),
                                resultSet.getString("date")
                        )
        );
    }

    @Override
    public List<Activity> getActivities() {
        return jdbcTemplate.query("SELECT * FROM activties",
                (resultSet, rowNum) ->
                        new Activity(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("ageLimit"),
                                resultSet.getDouble("price"),
                                resultSet.getInt("participant"),
                                resultSet.getInt("min"),
                                resultSet.getInt("max"),
                                resultSet.getString("instructor"),
                                resultSet.getString("date")

                        )
        );


    }


}
