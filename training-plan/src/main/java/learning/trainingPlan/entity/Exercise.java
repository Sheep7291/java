package learning.trainingPlan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Exercise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_plan_entity_id", updatable = false)
    private TrainingPlanEntity trainingPlanEntity;
    @Column(name = "name_of_exercise")
    private String nameOfExcercise;
    @Column(name = "range_of_reps")
    String rangeOfReps;
    @Column(name = "sets")
    private int sets;
    @Column(name = "break_between_sets")
    private String breakBetweenSets;
    @Column(name = "url_to_exercise")
    private String urlToExercise;
    @Column(name ="added_by")
    private String addedBy;
}
