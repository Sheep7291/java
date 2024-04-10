package learning.trainingPlan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Exercise {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "training_plan_entity_id")
    int trainingPlanEntityId;
    @Column(name = "name_of_exercise")
    String nameOfExcercise;
    @Column(name = "range_of_reps")
    String rangeOfReps;
    @Column(name = "sets")
    int sets;
    @Column(name = "break_between_sets")
    String breakBetweenSets;
    @Column(name = "url_to_exercise")
    String urlToExercise;
}
