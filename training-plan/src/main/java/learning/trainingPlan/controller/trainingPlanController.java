package learning.trainingPlan.controller;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainingPlans")
public class trainingPlanController {
    private final TrainingPlanService trainingPlanService;

    @GetMapping("")
    public List<TrainingPlanDTO> getTrainingPlan(){
        return trainingPlanService.getTrainingPlans();
    }
}
