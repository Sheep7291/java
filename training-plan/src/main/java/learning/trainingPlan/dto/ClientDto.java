package learning.trainingPlan.dto;

import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String username;
    private TrainerDto trainerDTO;
}
