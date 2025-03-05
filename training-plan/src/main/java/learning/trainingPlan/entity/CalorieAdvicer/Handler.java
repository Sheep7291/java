package learning.trainingPlan.entity.CalorieAdvicer;

public abstract class Handler {
    protected Handler succesor;

    public void setSuccesor(Handler succesor) {
        this.succesor = succesor;
    }

    public abstract void handleLifeStyleData(CalorieIntakeAdvicer calorieIntakeAdvicer);
}
