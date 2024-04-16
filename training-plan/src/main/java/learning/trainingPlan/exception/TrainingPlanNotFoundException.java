package learning.trainingPlan.exception;

public class TrainingPlanNotFoundException extends RuntimeException {
    public TrainingPlanNotFoundException(String message){
        super(message);
    }
}
