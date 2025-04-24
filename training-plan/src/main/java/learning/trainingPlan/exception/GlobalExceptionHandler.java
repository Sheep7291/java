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
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((errorResponse));
    }

    @ExceptionHandler({TrainingPlanAlreadyExist.class})
    public ResponseEntity<Object> handleAlreadyExistPlanException(TrainingPlanAlreadyExist exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body((errorResponse));
    }

    @ExceptionHandler({ClientAlreadyHaveTrainerException.class})
    public ResponseEntity<Object> handleClientAlreadyHaveTrainerException(ClientAlreadyHaveTrainerException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body((errorResponse));
    }

    @ExceptionHandler({GenderNotFoundException.class})
    public ResponseEntity<Object> handleBadGenderException(GenderNotFoundException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((errorResponse));
    }

    @ExceptionHandler({ExerciseNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundExerciseException(ExerciseNotFoundException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((errorResponse));
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(), exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public  ResponseEntity<Object> handleNotFoundClientException(ClientNotFoundException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((errorResponse));
    }
}
