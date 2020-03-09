package adventurexp.demo.service;

import adventurexp.demo.model.Activity;
import adventurexp.demo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public void addActivity(Activity activity) {
        activityRepository.createActivity(activity);
    }

    public Activity findAcitivityById(int activityId) {
        return activityRepository.getActivity(activityId);
    }

    public void deleteActivity(int activityId ){ activityRepository.deleteActivity(activityId);}

    public void updateActivity(Activity activity){ activityRepository.updateActivity(activity);}

    public List<Activity> getAllActivities(){ return activityRepository.getActivities();}

}
