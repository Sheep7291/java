package learning.trainingPlan.jms;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InjuryDto  {
    @Size(min = 5, message = "username must be more than 5 signs")
    @Schema(hidden = true)
    private String username;
    private String nameOfInjury;
    @PastOrPresent
    private LocalDate timeWhenInjuryHappen;
    @Schema(hidden = true)
    private String source;
    private String injuryDetails;
}