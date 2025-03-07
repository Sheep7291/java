package learning.trainingPlan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExerciseDto {
    @Schema(description = "id", hidden = true)
    private Long id;
    @Schema(description = "trainingPlanEntityId", hidden = true)
    private Long trainingPlanEntityId;
    private String nameOfExcercise;
    private String rangeOfReps;
    private int sets;
    private String breakBetweenSets;
    private String urlToExercise;
    @Schema(description = "addedBy", hidden = true)
    private String addedBy;
}
