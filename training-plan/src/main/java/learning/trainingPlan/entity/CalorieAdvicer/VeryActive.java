package learning.trainingPlan.entity.CalorieAdvicer;

public class VeryActive extends Handler{
    @Override
    public void handleLifeStyleData(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        calorieIntakeAdvicer.setcalories((int) (calorieIntakeAdvicer.getCalories()*1.9));
    }
}
