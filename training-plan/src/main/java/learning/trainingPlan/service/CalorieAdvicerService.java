package learning.trainingPlan.service;

import learning.trainingPlan.entity.CalorieAdvicer.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalorieAdvicerService {

    public Integer calculateIntakeCalories(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        calorieIntakeAdvicer.calculatecalories();
        Sedentary sedentary = new Sedentary();
        Lightly lightly = new Lightly();
        Moderately moderately = new Moderately();
        Active active = new Active();
        VeryActive veryActive = new VeryActive();

        sedentary.setSuccesor(lightly);
        lightly.setSuccesor(moderately);
        moderately.setSuccesor(active);
        active.setSuccesor(veryActive);

        sedentary.handleLifeStyleData(calorieIntakeAdvicer);
        return calorieIntakeAdvicer.getCalories();
    }
}
