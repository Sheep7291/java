package learning.trainingPlan.entity.CalorieAdvicer;

public class Active extends Handler {
    @Override
    public void handleLifeStyleData(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        if (calorieIntakeAdvicer.getActivity() == Activity.ACTIVE) {
            calorieIntakeAdvicer.setcalories((int) (calorieIntakeAdvicer.getCalories() * 1.55));
        } else {
            succesor.handleLifeStyleData(calorieIntakeAdvicer);
        }
    }
}
