package learning.trainingPlan.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String username;
    @Schema(hidden = true)
    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = true)
    private Trainer trainer;
}
