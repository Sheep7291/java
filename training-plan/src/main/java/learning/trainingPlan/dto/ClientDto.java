package learning.trainingPlan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    @NotBlank
    private String username;
    private TrainerDto trainerDTO;
}
