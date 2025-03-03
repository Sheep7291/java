package learning.trainingPlan.service;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.repository.ClientRepository;
import learning.trainingPlan.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final ClientService clientService;
    private final ClientRepository clientRepository;

public void addTrainer(Trainer trainer){
    trainerRepository.save(trainer);
}

public void getTrainerClients(Trainer trainer){
    List<Client> clients = clientRepository.findByTrainerId(trainer.getId());
}

private Trainer getTrainer(Authentication user){
    String username = user.getName();
    return trainerRepository.findByUsername(username);
}
}
