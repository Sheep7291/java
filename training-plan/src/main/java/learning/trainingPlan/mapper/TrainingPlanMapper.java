package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface TrainingPlanMapper {
    List<TrainingPlanDTO> fromTrainingPLanEntityListToTrainingPlanDTOList(List<TrainingPlanEntity> trainingPlanEntityList);
    @Mapping(target = "exerciseDTO" , source = "exercise" )
    TrainingPlanDTO trainingPlanEntityToTrainingPlanDTO(TrainingPlanEntity trainingPlanEntity);

    List<TrainingPlanEntity> fromTrainingPlanDTOListTOtrainingPLanEntity(List<TrainingPlanDTO> trainingPlanDTOList);
    @Mapping(target = "exercise", source = "exerciseDTO")
    TrainingPlanEntity trainingPlanDTOToTrainingPlanEntity(TrainingPlanDTO trainingPlanDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainingPlanFromDTO(TrainingPlanDTO trainingPlanDTO, @MappingTarget TrainingPlanEntity trainingPlanEntity);
}
