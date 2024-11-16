package learning.trainingPlan.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message){
        super(message);
    }
}
