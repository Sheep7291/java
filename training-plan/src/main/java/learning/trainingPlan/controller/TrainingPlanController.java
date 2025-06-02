package learning.trainingPlan.controller;

import learning.trainingPlan.dto.ExerciseDto;
import learning.trainingPlan.dto.TrainingPlanDto;
import learning.trainingPlan.response.ResponseObject;
import learning.trainingPlan.service.ExerciseService;
import learning.trainingPlan.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainingPlans")
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;
    private final ExerciseService exerciseService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TrainingPlanDto> getTrainingPlan() {
        return trainingPlanService.getTrainingPlans();
    }


    @GetMapping("/my-today")
    public TrainingPlanDto getMyTrainingPlansForToday(Authentication user) {
        String username = user.getName();
        return trainingPlanService.getLoggedUserTrainingPlanForToday(username);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> createTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDTO, Authentication user) {
        String username = user.getName();
        ResponseObject responseMessage = new ResponseObject("Training Plan added successfully");
        trainingPlanService.createTrainingPlan(trainingPlanDTO, username);
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping("/by-user")
    public List<TrainingPlanDto> getTrainingPlansLoggedUser(Authentication user) {
        String username = user.getName();
        return trainingPlanService.getLoggedUserUpcomingTrainingPlans(username);
    }

    @PostMapping("/exercises")
    @Transactional
    public ResponseEntity<String> createExercises(@RequestParam Long trainingPlanId, @RequestBody ExerciseDto exerciseDTO) {
        exerciseService.createExercise(exerciseDTO, trainingPlanId);
        return ResponseEntity.ok("Exercises Added");
    }

    @DeleteMapping("exercises/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.ok("Exercise deleted successfully");
    }

    @PostMapping("exercise/add")
    @Transactional
    public ResponseEntity<String> addToTrainingPlan(Authentication user, @RequestParam LocalDate localDate, @RequestBody ExerciseDto exerciseDTO) {
        exerciseService.addExerciseToTrainingPlan(exerciseDTO, user.getName(), localDate);
        return ResponseEntity.ok("Exercises added");
    }

    @PutMapping("")
    public ResponseEntity<String> updateTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDTO) {
        trainingPlanService.updateTrainingPlan(trainingPlanDTO);
        return ResponseEntity.ok("Training Plan modified successfully");
    }

    @PutMapping("/move/{days}")
    @Transactional
    public ResponseEntity<String> moveTrainingPlans(@PathVariable int days) {
        trainingPlanService.moveTrainingPlansByDays(days);
        return ResponseEntity.ok("Training Plan moved successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainingPlan(@PathVariable Long id) {
        trainingPlanService.deleteTrainingPLan(id);
        return ResponseEntity.ok("Training Plan Deleted successfully!");
    }
}
