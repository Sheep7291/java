package learning.trainingPlan.dto;

import lombok.Data;

@Data
public class Exercise {
    private Long id;
    private Long trainingPlanEntityId;
    private String nameOfExcercise;
    private String rangeOfReps;
    private int sets;
    private String breakBetweenSets;
    private String urlToExercise;
}
