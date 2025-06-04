package learning.trainingPlan.controller;

import jakarta.validation.Valid;
import learning.trainingPlan.entity.Client;
import learning.trainingPlan.response.ResponseObject;
import learning.trainingPlan.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("add")
    public ResponseEntity<String> addClient(@Valid @RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.ok("Client added successfully");
    }

    @PostMapping("/quit-from-trainer")
    public ResponseEntity<ResponseObject> quitFromTrainer(Authentication authentication){
        String clientUsername = authentication.getName();
        clientService.quitFromTrainer(clientUsername);
        ResponseObject responseObject = new ResponseObject("Client quit from trainer");
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("")
    public ResponseEntity<Client> getClientByUsername(String username){
        Client client = clientService.getClientByUsername(username);
        return ResponseEntity.ok(client);
    }
}
