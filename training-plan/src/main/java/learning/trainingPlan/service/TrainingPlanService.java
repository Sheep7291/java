package learning.trainingPlan.service;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.mapper.TrainingPlanMapper;
import learning.trainingPlan.repository.TrainingPlanRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingPlanService {
    final private TrainingPlanRepository trainingPlanRepository;
    private final TrainingPlanMapper trainingPlanMapper = Mappers.getMapper(TrainingPlanMapper.class);

    public List<TrainingPlanDTO> getTrainingPlans(){
        return  trainingPlanMapper.fromTrainingPLanEntityListToTrainingPlanDTOList(trainingPlanRepository.findFirst10ByOrderById());
    }
}