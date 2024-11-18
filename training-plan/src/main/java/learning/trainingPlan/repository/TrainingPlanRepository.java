package learning.trainingPlan.repository;

import learning.trainingPlan.entity.TrainingPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlanEntity, Long> {
    List<TrainingPlanEntity> findFirst10ByOrderById();
    List<TrainingPlanEntity> findByCreatedBy(String username);
    List<TrainingPlanEntity> findByCreatedByAndTrainingDateAfter(String username, LocalDate localDate);

    List<TrainingPlanEntity> findByTrainingDateAfter(LocalDate localDate);

    TrainingPlanEntity findByCreatedByAndTrainingDate(String username, LocalDate localDate);
}
