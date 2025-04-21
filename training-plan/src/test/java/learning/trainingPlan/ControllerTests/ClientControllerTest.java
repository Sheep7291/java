package learning.trainingPlan.ControllerTests;

import learning.trainingPlan.entity.Client;
import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.exception.ClientNotFoundException;
import learning.trainingPlan.service.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @MockBean
    ClientService clientService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /client/byUsername Unathorized")
    void testGetClientByUsernameUnauthorized()throws Exception{
        Trainer mockTrainer = new Trainer();
        mockTrainer.setUsername("Trainer name");
        mockTrainer.setId(1L);
        mockTrainer.setClients(new ArrayList<>());
        Client mockClient = new Client();
        mockClient.setId(1L);
        mockClient.setUsername("Client Name");
        mockClient.setTrainer(mockTrainer);

        doReturn(mockClient).when(clientService).getClientByUsername("Client Name");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients").param("username", "Client Name"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Unathorized"));

    }

    @Test
    @DisplayName("GET /client/byUsername Authorized")
    void testGetClientByUsernameAuthorized()throws Exception {
        Trainer mockTrainer = new Trainer();
        mockTrainer.setUsername("Trainer name");
        mockTrainer.setId(1L);
        mockTrainer.setClients(new ArrayList<>());
        Client mockClient = new Client();
        mockClient.setId(1L);
        mockClient.setUsername("Client Name");
        mockClient.setTrainer(mockTrainer);

        doReturn(mockClient).when(clientService).getClientByUsername("Client Name");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients").param("username", "Client Name")
                        .with(SecurityMockMvcRequestPostProcessors.user("Sheep")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));

    }

    @Test
    @DisplayName("GET /client/byUsername NotFound")
    void testGetClientByUsernameNotFound()throws Exception{
        doThrow(new ClientNotFoundException("Client not found"))
                .when(clientService).getClientByUsername("Client Name");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username", "Client Name")
                        .with(SecurityMockMvcRequestPostProcessors.user("Sheep")))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Client not found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("/api/clients"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());

    }

}
