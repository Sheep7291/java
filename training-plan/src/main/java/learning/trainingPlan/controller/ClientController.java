package learning.trainingPlan.controller;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.service.ClientService;
import learning.trainingPlan.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/add")//lepiej nie zostawiać tu pustego stringa "/add" albo /add-client
    public ResponseEntity<String> addClient(@RequestBody Client client){ //lepiej unikać zwracania samego Stringa. Lepiej stworzyć record z polem stringowym
        clientService.addClient(client);
        return ResponseEntity.ok("Client added successfully");
    }
}
