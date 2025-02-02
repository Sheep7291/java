package learning.trainingPlan.service;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientService {

    final private ClientRepository clientRepository;

    public void addClient(Client client){
        clientRepository.save(client);
    }
}
