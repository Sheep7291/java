package learning.trainingPlan.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data

public class TrainingPlanDTO {
    private Long id;
    private LocalDateTime trainingDate;
    private List<Exercise> exercise;
    private StatusOfTraining statusOfTraining;
}
