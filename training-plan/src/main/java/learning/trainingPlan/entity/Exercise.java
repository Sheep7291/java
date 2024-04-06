package learning.trainingPlan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    int trainingPlanEntityId;
    String nameOfExcercise;
    String rangeOfReps;
    int sets;
    String breakBetweenSets;
    String urlToExercise;
}
