package learning.trainingPlan.dto;

import lombok.Data;

@Data
public class ExerciseDTO {
    private Long id;
    private Long trainingPlanEntityId;
    private String nameOfExcercise;
    private String rangeOfReps;
    private int sets;
    private String breakBetweenSets;
    private String urlToExercise;
}
