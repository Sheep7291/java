package learning.trainingPlan.controller;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createTrainingPlan(@RequestBody TrainingPlanDTO trainingPlanDTO){
        trainingPlanService.createTrainingPlan( trainingPlanDTO);
        return ResponseEntity.ok("Training Plan Added successfully");
    }

    @PutMapping("")
    public ResponseEntity<String> updateTrainingPlan(@RequestBody TrainingPlanDTO trainingPlanDTO){
        trainingPlanService.updateTrainingPlan(trainingPlanDTO);
        return ResponseEntity.ok("Training Plan modified successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainingPlan(@PathVariable Long id){
        trainingPlanService.deleteTrainingPLan(id);
        return ResponseEntity.ok("Training Plan Deleted successfully!");
    }
}
