package learning.trainingPlan.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class TrainingPlanDTO {
    private Long id;
    private LocalDate trainingDate;
    private List<ExerciseDTO> exerciseDTO;
    private StatusOfTraining statusOfTraining;
}
