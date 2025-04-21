package learning.trainingPlan.exception;

import jakarta.servlet.http.HttpServletRequest;
import learning.trainingPlan.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({TrainingPlanNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundPlanException(TrainingPlanNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({TrainingPlanAlreadyExist.class})
    public ResponseEntity<Object> handleAlreadyExistPlanException(TrainingPlanAlreadyExist exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler({ClientAlreadyHaveTrainerException.class})
    public ResponseEntity<Object> handleClientAlreadyHaveTrainerException(ClientAlreadyHaveTrainerException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler({GenderNotFoundException.class})
    public ResponseEntity<Object> handleBadGenderException(GenderNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler({ExerciseNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundExerciseException(ExerciseNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public  ResponseEntity<Object> handleNotFoundClientException(ClientNotFoundException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((errorResponse));
    }
}
