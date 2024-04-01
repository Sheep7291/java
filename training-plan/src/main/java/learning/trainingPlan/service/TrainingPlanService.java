package learning.trainingPlan.service;

import learning.trainingPlan.entity.TrainingPlanEntity;
import learning.trainingPlan.repository.TrainingPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingPlanService {
    final private TrainingPlanRepository trainingPlanRepository;

    public List<TrainingPlanEntity> getTrainingPlans(){
        return  trainingPlanRepository.findFirst10ByOrderById();
    }
}
