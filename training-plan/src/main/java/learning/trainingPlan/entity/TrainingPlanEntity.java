package learning.trainingPlan.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "trainingplan")
public class TrainingPlanEntity {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "trainingdate")
    LocalDateTime trainingDate;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "training_plan_entity_id", updatable = false)
    List<Exercise> exercise;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusoftraining")
    StatusOfTrainig statusOfTraining;

}
