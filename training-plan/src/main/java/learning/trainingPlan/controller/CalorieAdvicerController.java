package learning.trainingPlan.controller;

import learning.trainingPlan.entity.CalorieAdvicer.CalorieIntakeAdvicer;
import learning.trainingPlan.service.CalorieAdvicerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api") //wypada rozważyć wersjonowanie /api/v1 na później
public class CalorieAdvicerController {
    private final CalorieAdvicerService calorieAdvicerService;

    @PostMapping("/calculateCaloriesIntake") //kebab case calculate-calories-intake
    public ResponseEntity<Integer> calculateCaloriesIntake(@RequestBody CalorieIntakeAdvicer calorieIntakeAdvicer) {
        return calorieAdvicerService.CalculateIntakeCalories(calorieIntakeAdvicer);
    }
}
