package learning.trainingPlan.controller;

import learning.trainingPlan.CountryClient;
import learning.trainingPlan.dto.ExerciseDto;
import learning.trainingPlan.dto.TrainingPlanDto;
import learning.trainingPlan.service.ExerciseService;
import learning.trainingPlan.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainingPlans")
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;
    private final ExerciseService exerciseService;
    private final CountryClient countryClient;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TrainingPlanDto> getTrainingPlan(){
        return trainingPlanService.getTrainingPlans();
    }

    @GetMapping("countries")
    public Object getCountries(@RequestParam String targetMuscle){
        String language = "english";
        return countryClient.getAllCountries(language, targetMuscle);
    }

    @GetMapping("/myToday")
    public TrainingPlanDto getMyTrainingPlansForToday(Authentication user){
        String username = user.getName();
        return trainingPlanService.getLoggedUserTrainingPlanForToday(username);
    }
    @PostMapping("/")
    public ResponseEntity<String> createTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDTO, Authentication user){
        String username = user.getName();
        trainingPlanService.createTrainingPlan(trainingPlanDTO, username);
        return ResponseEntity.ok("Training Plan Added successfully");
    }

    @GetMapping("/byUser")
    public List<TrainingPlanDto> getTrainingPlansLoggedUser(Authentication user){
        String username = user.getName();
        return trainingPlanService.getLoggedUserUpcomingTrainingPlans(username);
    }
    @PostMapping("/exercises")
    public ResponseEntity<String> createExercises(@RequestBody ExerciseDto exerciseDTO){
        exerciseService.createExercise( exerciseDTO);
        return ResponseEntity.ok("Exercises Added");
    }

    @DeleteMapping("exercises/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable Long id){
        exerciseService.deleteExercise(id);
        return ResponseEntity.ok("Exercise deleted successfully");
    }

    @PostMapping("exercise/add")
    public ResponseEntity<String> addToTrainingPlan(Authentication user, @RequestParam LocalDate localDate, @RequestBody ExerciseDto exerciseDTO){
        exerciseService.addExerciseToTrainingPlan(exerciseDTO, user.getName(), localDate);
        return ResponseEntity.ok("Exercises added");
    }

    @PutMapping("")
    public ResponseEntity<String> updateTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDTO){
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
