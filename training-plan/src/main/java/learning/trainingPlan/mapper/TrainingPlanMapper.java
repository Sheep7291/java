package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface TrainingPlanMapper {
    List<TrainingPlanDTO> fromTrainingPLanEntityListToTrainingPlanDTOList(List<TrainingPlanEntity> trainingPlanEntityList);

    TrainingPlanDTO trainingPlanEntityToTrainingPlanDTO(TrainingPlanEntity trainingPlanEntity);

    List<TrainingPlanEntity> fromTrainingPlanDTOListTOtrainingPLanEntity(List<TrainingPlanDTO> trainingPlanDTOList);

    TrainingPlanEntity trainingPlanDTOToTrainingPlanEntity(TrainingPlanDTO trainingPlanDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainingPlanFromDTO(TrainingPlanDTO trainingPlanDTO, @MappingTarget TrainingPlanEntity trainingPlanEntity);
}
