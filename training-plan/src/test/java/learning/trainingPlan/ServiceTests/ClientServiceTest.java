package learning.trainingPlan.ServiceTests;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private learning.trainingPlan.service.ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Find client By username")
    void testFindClientByUsername() {
    }

    @Test
    @DisplayName("Don't find client By username")
    void testFindClientByUsernameNoFound() {
        Trainer mockTrainer = new Trainer();
        mockTrainer.setUsername("Trainer name");
        mockTrainer.setId(1L);
        mockTrainer.setClients(new ArrayList<>());
        Client mockClient = new Client();
        mockClient.setId(1L);
        mockClient.setUsername("Client Name");
        mockClient.setTrainer(mockTrainer);

        doReturn(Optional.of(mockClient)).when(clientRepository).findByUsername("Client name");

        Optional<Client> returnedClient = Optional.ofNullable(clientService.getClientByUsername("Client name"));

        Assertions.assertTrue(returnedClient.isPresent(), "Client was found");
        Assertions.assertSame(returnedClient.get(), mockClient, "Client should be the same");


    }

}






