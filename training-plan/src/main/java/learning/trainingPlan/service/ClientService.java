package learning.trainingPlan.service;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.exception.UserAlreadyExistException;
import learning.trainingPlan.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    final private ClientRepository clientRepository;
    final private UserService userService;


    // TODO: rozważyć czy użyć w metodzie addClient switcha czy może chain w responsibility
    public void addClient(Client client) {
        if (userService.userExist(client.getUsername()) && clientAccountIsCreated(client.getUsername())) {
            throw new UserAlreadyExistException("Client already exist");
        } else if (userService.userExist(client.getUsername()) && !clientAccountIsCreated(client.getUsername())){
            clientRepository.save(client);
        }
        else{
            /* TODO: tutaj rzucić wyjątek że taki user nie istnieje
            throw new UserNoExistException("Client don't have account in our domain, please contact with client")
             */
        }
    }

    public void addClientToTrainer(){

    }

    private boolean clientAccountIsCreated(String username){
        Optional<Client> client = Optional.ofNullable(clientRepository.findByUsername(username));
        return client.isPresent();
    }

    private boolean clientHaveTrainer(String clientUsername){
        Client client = clientRepository.findByUsername(clientUsername);
        Optional<Trainer> trainer = Optional.ofNullable(client.getTrainer());
        return trainer.isPresent();
    }


/* TODO tutaj może coś wyodrębnić jak dodanie clienta na podstawie authenticate oraz dodawać coś dla trenera może
    public Client
    */
}
