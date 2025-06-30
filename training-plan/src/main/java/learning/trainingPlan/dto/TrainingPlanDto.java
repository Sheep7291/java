package learning.trainingPlan.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class TrainingPlanDto {
    @Schema(description = "id", hidden = true)
    private Long id;
    @FutureOrPresent
    private LocalDate trainingDate;
    @Size(min = 0, max = 12, message = "Consider if more than 12 exercises in your training plan was really needed")
    private List<ExerciseDto> exercises;
    private StatusOfTraining statusOfTraining;
    @Schema(description = "createdBy", hidden = true)
    private String createdBy;
}