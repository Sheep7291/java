package learning.trainingPlan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import learning.trainingPlan.validation.OnUpdate;
import learning.trainingPlan.validation.validationGroup.OnCreate;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingPlanUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5, message = "username must be at least 5  signs", groups = OnCreate.class)
    private String username;
    @NotBlank
    @Size(min = 7, message = "password must be at least 7 signs", groups = {OnCreate.class, OnUpdate.class})
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private UserPossibleRoles userPossibleRoles;
}
