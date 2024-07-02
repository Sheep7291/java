package learning.trainingPlan;

import jakarta.persistence.ForeignKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrainingPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingPlanApplication.class, args);
	}

}
