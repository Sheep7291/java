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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "trainingdate")
    LocalDateTime trainigDate;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "trainingPlanEntityId", updatable = false)
    List<Exercise> exercise;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusoftraining")
    StatusOfTrainig statusOfTraining;

}
