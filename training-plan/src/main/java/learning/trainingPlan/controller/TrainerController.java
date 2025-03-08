package learning.trainingPlan.controller;

import learning.trainingPlan.dto.TrainingPlanDto;
import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.response.ResponseObject;
import learning.trainingPlan.service.ClientService;
import learning.trainingPlan.service.TrainerService;
import learning.trainingPlan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainers")
public class TrainerController {
    private final TrainerService trainerService;
    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<String> createTrainer(@RequestBody Trainer trainer) {
        trainerService.addTrainer(trainer);
        return ResponseEntity.ok("Trainer created successfully");
    }

    @PostMapping("/client/add")
    public ResponseEntity<ResponseObject> addClient(@RequestBody Client client) {
        clientService.addClient(client);
        ResponseObject responseObject = new ResponseObject("Client created");
        return ResponseEntity.ok(responseObject);
    }

    @PostMapping("/client/add-to-trainer")
    public ResponseEntity<ResponseObject> addClientToTrainer(Authentication user, @RequestParam String clientUsername) {
        trainerService.addClientToTrainer(user, clientUsername);
        ResponseObject responseObject = new ResponseObject("Client added successfully to trainer");
        return ResponseEntity.ok(responseObject);
    }

    @PreAuthorize("hasRole('TRAINER')")
    @PostMapping("/client/add-training-plan")
    public ResponseEntity<ResponseObject> addTrainingPlanToClient(@RequestParam String clientUsername, @RequestBody TrainingPlanDto trainingPlanDto, Authentication user){
        trainerService.addTrainingPlanToClient(trainingPlanDto, clientUsername, user);
        ResponseObject response = new ResponseObject("Training plan added to client successfully");
        return ResponseEntity.ok(response);
    }
}
