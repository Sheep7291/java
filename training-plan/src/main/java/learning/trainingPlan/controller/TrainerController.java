package learning.trainingPlan.controller;

import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping("")
    public ResponseEntity<String> createTrainer(@RequestBody Trainer trainer){
        trainerService.addTrainer(trainer);
        return ResponseEntity.ok("Trainer created successfully");
    }
}
