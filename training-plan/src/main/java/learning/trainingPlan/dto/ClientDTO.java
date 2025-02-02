package learning.trainingPlan.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String username;
    private TrainerDTO trainerDTO;
}
