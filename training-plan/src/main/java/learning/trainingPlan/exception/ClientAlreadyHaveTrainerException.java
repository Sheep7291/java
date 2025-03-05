package learning.trainingPlan.exception;

public class ClientAlreadyHaveTrainerException extends RuntimeException {
    public ClientAlreadyHaveTrainerException(String message) {
        super(message);
    }
}
