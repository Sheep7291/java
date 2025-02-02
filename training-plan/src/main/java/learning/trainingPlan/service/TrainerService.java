package learning.trainingPlan.service;

import learning.trainingPlan.entity.Trainer;
import learning.trainingPlan.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

public void addTrainer(Trainer trainer){
    trainerRepository.save(trainer);
}
}
