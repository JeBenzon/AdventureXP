package adventurexp.demo.service;

import adventurexp.demo.model.Activity;
import adventurexp.demo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public void addActivity(Activity activity) {
        activityRepository.createActivity(activity);
    }

    public Activity findAcitivityById(int activityId) {
        return null;
    }


}
