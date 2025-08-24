package learning.trainingPlan.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "trainers")
public class Trainer {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @FutureOrPresent
    private LocalDate accountStartDate;
    @Future
    private LocalDate accountEndDate;
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;
    @Schema(hidden = true)
    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return ((accountStartDate != null && accountEndDate != null && !today.isBefore(accountStartDate) && !today.isAfter(accountEndDate)));
    }
}
