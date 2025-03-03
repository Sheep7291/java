package learning.trainingPlan.controller;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.response.ResponseObject;
import learning.trainingPlan.service.ClientService;
import learning.trainingPlan.service.TrainerService;
import learning.trainingPlan.service.UserService;
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
    private final ClientService clientService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createTrainer(@RequestBody Trainer trainer){
        trainerService.addTrainer(trainer);
        return ResponseEntity.ok("Trainer created successfully");
    }

    @PostMapping("/client/add")
    public ResponseEntity<ResponseObject> addClient(@RequestBody Client client){
        clientService.addClient(client);
        ResponseObject responseObject = new ResponseObject("Client created");
        return ResponseEntity.ok(responseObject);
    }
}
