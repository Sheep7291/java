package learning.trainingPlan.controller;

import learning.trainingPlan.entity.CalorieAdvicer.CalorieIntakeAdvicer;
import learning.trainingPlan.service.CalorieAdvicerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalorieAdvicerController {
    private final CalorieAdvicerService calorieAdvicerService;

    @GetMapping("/calculateCaloriesIntake")
    public Integer calculateCaloriesIntake(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        return calorieAdvicerService.calculateIntakeCalories(calorieIntakeAdvicer);
    }
}
