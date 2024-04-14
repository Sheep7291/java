package learning.trainingPlan.repository;

import learning.trainingPlan.entity.TrainingPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlanEntity, Long> {
    List<TrainingPlanEntity> findFirst10ByOrderById();
}
