package learning.trainingPlan.service;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import learning.trainingPlan.exception.TrainingPlanNotFoundException;
import learning.trainingPlan.mapper.TrainingPlanMapper;
import learning.trainingPlan.repository.TrainingPlanRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public void moveTrainingPlansByDays(int days) {
        LocalDate localDate = LocalDate.now();
        List<TrainingPlanEntity> trainingPlanEntityList = trainingPlanRepository.findByTrainingDateAfter(localDate);
        trainingPlanEntityList = trainingPlanEntityList.
                stream().
                map(trainingPlanEntity -> {
                    trainingPlanEntity
                            .setTrainingDate(trainingPlanEntity
                                    .getTrainingDate().
                                    plusDays(days));
                    return trainingPlanEntity;
                })
                .collect(Collectors.toList());
        trainingPlanRepository.saveAll(trainingPlanEntityList);
    }
}
