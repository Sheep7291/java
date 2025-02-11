package learning.trainingPlan.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class TrainingPlanDto {
    @Schema(description = "id", hidden = true)
    private Long id;
    private LocalDate trainingDate;
    private List<ExerciseDto> exerciseDTO;
    private StatusOfTraining statusOfTraining;
    @Schema(description = "createdBy", hidden = true)
    private String createdBy;
}
