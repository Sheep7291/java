package learning.trainingPlan.exception;

public class TrainingPlanAlreadyExist extends RuntimeException {
    public TrainingPlanAlreadyExist(String message){
        super(message);
    }
}