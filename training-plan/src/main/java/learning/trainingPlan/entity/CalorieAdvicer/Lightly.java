package learning.trainingPlan.entity.CalorieAdvicer;

public class Lightly extends Handler{
    @Override
    public void handleLifeStyleData(CalorieIntakeAdvicer calorieIntakeAdvicer) {
        if (calorieIntakeAdvicer.getActivity() == Activity.LIGHTLY){
            calorieIntakeAdvicer.setcalories((int) (calorieIntakeAdvicer.getCalories()*1.375));
        }
        else{
            succesor.handleLifeStyleData(calorieIntakeAdvicer);
        }
    }
}