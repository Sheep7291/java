package learning.trainingPlan.dto;

import lombok.Data;

@Data //zamiast @Data record
public class ClientDTO { //nazewnictwo DTO -> Dto
    private Long id;
    private String username;
    private TrainerDTO trainerDTO;
}
