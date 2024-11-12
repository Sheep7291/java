package learning.trainingPlan.controller;

import learning.trainingPlan.CountryClient;
import learning.trainingPlan.dto.ExerciseDTO;
import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.service.AddUserService;
import learning.trainingPlan.service.ExerciseService;
import learning.trainingPlan.service.TrainingPlanService;
import learning.trainingPlan.service.TrainingPlanUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainingPlans")
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;
    private final ExerciseService exerciseService;
    private final CountryClient countryClient;
    private final AddUserService addUserService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TrainingPlanDTO> getTrainingPlan(){
        return trainingPlanService.getTrainingPlans();
    }

    @GetMapping("countries")
    public List<Object> getCountries(@RequestParam String targetMuscle){
        String language = "english";
        return countryClient.getAllCountries(language, targetMuscle);
    }

    @PostMapping("/")
    public ResponseEntity<String> createTrainingPlan(@RequestBody TrainingPlanDTO trainingPlanDTO){
        trainingPlanService.createTrainingPlan( trainingPlanDTO);
        return ResponseEntity.ok("Training Plan Added successfully");
    }
    @PostMapping("/exercises")
    public ResponseEntity<String> createExercises(@RequestBody ExerciseDTO exerciseDTO){
        exerciseService.createExercise( exerciseDTO);
        return ResponseEntity.ok("Exercises Added");
    }

    @PutMapping("")
    public ResponseEntity<String> updateTrainingPlan(@RequestBody TrainingPlanDTO trainingPlanDTO){
        trainingPlanService.updateTrainingPlan(trainingPlanDTO);
        return ResponseEntity.ok("Training Plan modified successfully");
    }

    @PutMapping("/move/{days}")
    public ResponseEntity<String> moveTrainingPlans(@PathVariable int days){
        trainingPlanService.moveTrainingPlansByDays(days);
        return ResponseEntity.ok("Training Plan moved successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainingPlan(@PathVariable Long id){
        trainingPlanService.deleteTrainingPLan(id);
        return ResponseEntity.ok("Training Plan Deleted successfully!");
    }
}
