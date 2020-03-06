package adventurexp.demo.repository;

import adventurexp.demo.model.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepositoryImpl implements ActivityRepository {

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
                "UPDATE activities SET ageLimit = ?, price = ?,participant = ?,instructor = ?,name = ?,date = ?,max = ?, min = ?, where "
                activity.getAgeLimit(),activity.getPrice(), activity.getParticipants(),activity.getInstructor(), activity.getName(),activity.getDate(),activity.getMaxSlots(), activity.getMinSlots()

        );
    }

    @Override
    public int getActivity() {
        return 0;
    }
}
