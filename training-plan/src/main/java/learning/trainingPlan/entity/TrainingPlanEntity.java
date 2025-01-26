package learning.trainingPlan.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "trainingplan")
public class TrainingPlanEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "trainingdate")
    private LocalDate trainingDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "training_plan_entity_id", updatable = false)
    private List<Exercise> exercise;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusoftraining")
    private StatusOfTraining statusOfTraining;
    @Column(name = "created_by")
    private String createdBy;
}
