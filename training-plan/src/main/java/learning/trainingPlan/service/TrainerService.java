package learning.trainingPlan.service;

import learning.trainingPlan.dto.TrainingPlanDto;
import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.exception.UserAlreadyExistException;
import learning.trainingPlan.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final ClientService clientService;
    private final TrainingPlanService trainingPlanService;

    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public List<Client> getTrainerClients(Trainer trainer) {
        List<Client> clients = clientService.getClientsByTrainer(trainer);
        return clients;
    }

    private Trainer getTrainer(Authentication user) {
        String username = user.getName();
        return trainerRepository.findByUsername(username);
    }

    public void addClientToTrainer(Authentication user, String clientUsername) {
        Trainer trainer = getTrainer(user);
        clientService.addClientToTrainer(trainer, clientUsername);
    }

    public void addTrainingPlanToClient(TrainingPlanDto trainingPlanDto, String clientUsername, Authentication trainerUser) {
        Trainer trainer = getTrainer(trainerUser);
        Client client = clientService.getClientByUsername(clientUsername);
        if (client.getTrainer() == trainer) {
            trainingPlanService.createTrainingPlan(trainingPlanDto, clientUsername);
        }
        else{
            throw new UserAlreadyExistException("User already have treiner, please choose other client");
        }
    }
}
