package learning.trainingPlan.controller;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import learning.trainingPlan.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainingPlans")
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;

    @GetMapping("")
    public List<TrainingPlanDTO> getTrainingPlan(){
        return trainingPlanService.getTrainingPlans();
    }

    @PostMapping("")
    public void createTrainingPlan(@RequestBody TrainingPlanDTO trainingPlanDTO){
        trainingPlanService.createTrainingPlan( trainingPlanDTO);
    }

    @PutMapping("")
    public void updateTrainingPlan(@RequestBody TrainingPlanDTO trainingPlanDTO){
        trainingPlanService.updateTrainingPlan(trainingPlanDTO);
    }
}
