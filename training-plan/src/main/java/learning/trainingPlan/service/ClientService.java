package learning.trainingPlan.service;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.exception.ClientAlreadyHaveTrainerException;
import learning.trainingPlan.exception.UserAlreadyExistException;
import learning.trainingPlan.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    final private ClientRepository clientRepository;


    public void addClient(Client client) {
        if (clientAccountIsCreated(client.getUsername())){
            throw new UserAlreadyExistException("Client already exist");
        }
        else{
            clientRepository.save(client);
        }
    }

    public void addClientToTrainer(Trainer trainer, String clientUsername) {
        if (clientHaveTrainer(clientUsername)) {
            throw new ClientAlreadyHaveTrainerException("Client already have trainer, please choose another client or ask client to quit trainer");
        } else {
            Client client = clientRepository.findByUsername(clientUsername);
            client.setTrainer(trainer);
            clientRepository.save(client);
        }
    }

    private boolean clientAccountIsCreated(String username) {
        Optional<Client> client = Optional.ofNullable(clientRepository.findByUsername(username));
        return client.isPresent();
    }

    private boolean clientHaveTrainer(String clientUsername) {
        Client client = clientRepository.findByUsername(clientUsername);
        Optional<Trainer> trainer = Optional.ofNullable(client.getTrainer());
        return trainer.isPresent();
    }

    public void quitFromTrainer(String username) {
        Client client = clientRepository.findByUsername(username);
        client.setTrainer(null);
        clientRepository.save(client);

    }

}
