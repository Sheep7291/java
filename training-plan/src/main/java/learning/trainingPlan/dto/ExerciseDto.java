package learning.trainingPlan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ExerciseDto {
    @Schema(description = "id", hidden = true)
    private Long id;
    @Schema(description = "trainingPlanEntityId", hidden = true)
    private Long trainingPlanEntityId;
    private String nameOfExcercise;
    private String rangeOfReps;
    @Min(value = 1, message = "The sets should not be lower than {value}")
    private int sets;
    private String breakBetweenSets;
    private String urlToExercise;
    @Schema(description = "addedBy", hidden = true)
    private String addedBy;
}
