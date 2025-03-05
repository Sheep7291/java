package learning.trainingPlan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({TrainingPlanNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundPlanException(TrainingPlanNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({TrainingPlanAlreadyExist.class})
    public ResponseEntity<Object> handleAlreadyExistPlanException(TrainingPlanAlreadyExist exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler({ClientAlreadyHaveTrainerException.class})
    public ResponseEntity<Object> handleClientAlreadyHaveTrainerException(ClientAlreadyHaveTrainerException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler({GenderNotFoundException.class})
    public ResponseEntity<Object> handleBadGenderException(GenderNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler({ExerciseNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundExerciseException(ExerciseNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }
}
