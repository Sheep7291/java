package learning.trainingPlan.entity.CalorieAdvicer;

public class Moderately extends Handler{
    @Override
    public void handleLifeStyleData(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        if (calorieIntakeAdvicer.getActivity() == Activity.MODERATELY){
            calorieIntakeAdvicer.setcalories((int) (calorieIntakeAdvicer.getCalories()*1.2));
        }
        else{
            succesor.handleLifeStyleData(calorieIntakeAdvicer);
        }
    }
}
