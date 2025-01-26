package learning.trainingPlan.entity.CalorieAdvicer;

import io.swagger.v3.oas.annotations.media.Schema;
import learning.trainingPlan.exception.GenderNotFoundException;
import lombok.Getter;

@Getter
public class CalorieIntakeAdvicer {
    private final Activity activity;
    private final Integer age;
    private final Integer height;
    private final Integer weight;
    private final Gender gender;
    @Schema(description = "calories", hidden = true)
    private Integer calories;

    public CalorieIntakeAdvicer(Activity activity, Integer age, Integer height, Integer weight, Gender gender) {
        this.activity = activity;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public void calculatecalories() {
        switch (gender) {
            case MALE -> setcalories((int) Math.ceil(655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age)));
            case FEMALE -> setcalories((int) Math.ceil(66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age)));
            default ->
                    throw new GenderNotFoundException("There are only two genders, please choose between male and female");
        }
    }
    public void setcalories(Integer calories){
        this.calories = calories;
    }
}
