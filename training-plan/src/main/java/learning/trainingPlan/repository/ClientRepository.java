package learning.trainingPlan.repository;

import learning.trainingPlan.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username);

    List<Client> findByTrainerId(Long trainerId);
}
