package learning.trainingPlan.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class TrainingPlanDTO {
    private Long id;
    private LocalDate trainingDate;
    private List<ExerciseDTO> exerciseDTO;
    private StatusOfTraining statusOfTraining;
    @Schema(description = "createdBy", hidden = true)
    private String createdBy;
}
