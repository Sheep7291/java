package learning.trainingPlan.exception;

import jakarta.servlet.http.HttpServletRequest;
import learning.trainingPlan.dto.ConstraintViolation;
import learning.trainingPlan.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){
    ProblemDetail validationProblemDetail =
    ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Validation error");

        List<ConstraintViolation> errors = exception.getFieldErrors()
                .stream()
                .map(violation -> ConstraintViolation.builder()
                        .message(violation.getDefaultMessage())
                        .fieldName(violation.getField())
                        .rejectedValue(Objects.isNull(
                                violation.getRejectedValue()) ?
                                "null":
                                violation.getRejectedValue().toString())
                        .build())
                .collect(Collectors.toList());
        validationProblemDetail.setProperty("errors", errors);
        return validationProblemDetail;
    }


    @ExceptionHandler({ClientAlreadyHaveTrainerException.class})
    public ProblemDetail handleClientAlreadyHaveTrainerException(ClientAlreadyHaveTrainerException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgumentException(IllegalArgumentException exception){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ProblemDetail handleUserAlreadyExistException(UserAlreadyExistException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public  ResponseEntity<Object> handleNotFoundClientException(ClientNotFoundException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((errorResponse));
    }
}
