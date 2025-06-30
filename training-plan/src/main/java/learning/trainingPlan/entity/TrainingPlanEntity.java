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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "trainingdate")
    private LocalDate trainingDate;
    @OneToMany(mappedBy = "trainingPlanEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exercise> exercises;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusoftraining")
    private StatusOfTraining statusOfTraining;
    @Column(name = "created_by")
    private String createdBy;
}
