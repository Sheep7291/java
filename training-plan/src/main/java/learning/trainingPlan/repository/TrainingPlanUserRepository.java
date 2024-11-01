package learning.trainingPlan.repository;

import learning.trainingPlan.entity.TrainingPlanUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingPlanUserRepository  extends JpaRepository<TrainingPlanUser, Long> {

    Optional<TrainingPlanUser> findByUsername(String username);
}
