package learning.trainingPlan.service;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.exception.ClientAlreadyHaveTrainerException;
import learning.trainingPlan.exception.ClientNotFoundException;
import learning.trainingPlan.exception.UserAlreadyExistException;
import learning.trainingPlan.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    final private ClientRepository clientRepository;


    public List<Client> getClientsByTrainer(Trainer trainer) {
        return clientRepository.findByTrainerId(trainer.getId());
    }

    public Client getClientByUsername(String clientUsername) {
        return clientRepository.findByUsername(clientUsername).orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    public void addClient(Client client) {
        if (clientAccountIsCreated(client.getUsername())) {
            throw new UserAlreadyExistException("Client already exist");
        } else {
            clientRepository.save(client);
        }
    }

    public void addClientToTrainer(Trainer trainer, String clientUsername) {
        if (clientHaveTrainer(clientUsername)) {
            throw new ClientAlreadyHaveTrainerException("Client already have trainer, please choose another client or ask client to quit trainer");
        } else {
            Client client = clientRepository.findByUsername(clientUsername).orElseThrow(() -> new ClientNotFoundException("Client not found"));
            client.setTrainer(trainer);
            clientRepository.save(client);
        }
    }

    private boolean clientAccountIsCreated(String username) {
        Client client = clientRepository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        return true;
    }

    private boolean clientHaveTrainer(String clientUsername) {
        Client client = clientRepository.findByUsername(clientUsername).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        Optional<Trainer> trainer = Optional.ofNullable(client.getTrainer());
        return trainer.isPresent();
    }

    public void quitFromTrainer(String username) {
        Client client = clientRepository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        client.setTrainer(null);
        clientRepository.save(client);

    }

}
