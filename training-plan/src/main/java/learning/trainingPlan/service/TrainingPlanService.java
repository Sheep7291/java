package learning.trainingPlan.service;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import learning.trainingPlan.mapper.TrainingPlanMapper;
import learning.trainingPlan.repository.ExerciseRepository;
import learning.trainingPlan.repository.TrainingPlanRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TrainingPlanService {
    final private TrainingPlanRepository trainingPlanRepository;
    final private ExerciseRepository exerciseRepository;
    private final TrainingPlanMapper trainingPlanMapper = Mappers.getMapper(TrainingPlanMapper.class);

    public List<TrainingPlanDTO> getTrainingPlans(){
        return  trainingPlanMapper.fromTrainingPLanEntityListToTrainingPlanDTOList(trainingPlanRepository.findFirst10ByOrderById());
    }

    public void createTrainingPlan(TrainingPlanDTO trainingPlanDTO){
        trainingPlanRepository.save(trainingPlanMapper.trainingPlanDTOToTrainingPlanEntity(trainingPlanDTO));
    }

    public void updateTrainingPlan(TrainingPlanDTO trainingPlanDTO) {
        TrainingPlanEntity trainingPlanEntity = trainingPlanRepository.findById(trainingPlanDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("Training plan not found with ID: " + trainingPlanDTO.getId()));;
        trainingPlanMapper.updateTrainingPlanFromDTO( trainingPlanDTO, trainingPlanEntity);
        trainingPlanRepository.save(trainingPlanEntity);
    }
}
