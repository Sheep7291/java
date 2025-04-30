package learning.trainingPlan;

import jakarta.persistence.ForeignKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
public class TrainingPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingPlanApplication.class, args);
	}

}
