package learning.trainingPlan.dto;

import learning.trainingPlan.entity.Client;

import java.time.LocalDate;
import java.util.List;

public class TrainerDTO {
    private Long id;
    private String username;
    private LocalDate accountStartDate;
    private LocalDate accountEndDate;
    private List<ClientDTO> clientDTOS;
}