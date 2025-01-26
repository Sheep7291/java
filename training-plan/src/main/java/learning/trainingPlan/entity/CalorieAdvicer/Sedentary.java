package learning.trainingPlan.entity.CalorieAdvicer;

public class Sedentary extends Handler{
    @Override
    public void handleLifeStyleData(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        if (calorieIntakeAdvicer.getActivity() == Activity.SEDENTARY){
            calorieIntakeAdvicer.setcalories((int) (calorieIntakeAdvicer.getCalories()*1.2));
        }
        else{
            succesor.handleLifeStyleData(calorieIntakeAdvicer);
        }
    }
}
