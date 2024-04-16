package learning.trainingPlan.service;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import learning.trainingPlan.exception.TrainingPlanNotFoundException;
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

    public List<TrainingPlanDTO> getTrainingPlans() {
        return trainingPlanMapper.fromTrainingPLanEntityListToTrainingPlanDTOList(trainingPlanRepository.findFirst10ByOrderById());
    }

    public void createTrainingPlan(TrainingPlanDTO trainingPlanDTO) {
        trainingPlanRepository.save(trainingPlanMapper.trainingPlanDTOToTrainingPlanEntity(trainingPlanDTO));
    }

    public void updateTrainingPlan(TrainingPlanDTO trainingPlanDTO) {
        TrainingPlanEntity trainingPlanEntity = trainingPlanRepository.findById(trainingPlanDTO.getId())
                .orElseThrow(() -> new TrainingPlanNotFoundException("Training plan not found with ID: " + trainingPlanDTO.getId()));
        trainingPlanMapper.updateTrainingPlanFromDTO(trainingPlanDTO, trainingPlanEntity);
        trainingPlanRepository.save(trainingPlanEntity);
    }

    public void deleteTrainingPLan(Long id) {
        trainingPlanRepository.findById(id).orElseThrow(() -> new TrainingPlanNotFoundException("Training plan not found with ID: " + id));
        trainingPlanRepository.deleteById(id);
    }
}
