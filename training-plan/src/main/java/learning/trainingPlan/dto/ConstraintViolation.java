package learning.trainingPlan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstraintViolation {

    private String fieldName;
    private String message;
    private String rejectedValue;
}
