package learning.trainingPlan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class InjuryDto implements Serializable {
    @Size(min = 5, message = "username must be more than 5 signs")
    @Schema(hidden = true)
    private String username;
    private String nameOfInjury;
    @PastOrPresent
    private LocalDate TimeWhenInjuryHappen;
}
