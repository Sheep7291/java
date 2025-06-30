package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.TrainingPlanDto;
import learning.trainingPlan.entity.Exercise;
import learning.trainingPlan.entity.TrainingPlanEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ExerciseMapper.class})
public interface TrainingPlanMapper {
    List<TrainingPlanDto> fromTrainingPLanEntityListToTrainingPlanDTOList(List<TrainingPlanEntity> trainingPlanEntityList);

    @Mapping(target = "exercises", source = "exercises")
    TrainingPlanDto trainingPlanEntityToTrainingPlanDTO(TrainingPlanEntity trainingPlanEntity);

    List<TrainingPlanEntity> fromTrainingPlanDTOListTotrainingPLanEntity(List<TrainingPlanDto> trainingPlanDtoList);

    @Mapping(target = "exercises", source = "exercises")
    TrainingPlanEntity trainingPlanDTOToTrainingPlanEntity(TrainingPlanDto trainingPlanDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainingPlanFromDTO(TrainingPlanDto trainingPlanDTO, @MappingTarget TrainingPlanEntity trainingPlanEntity);

    @AfterMapping
    default void linkExercises(@MappingTarget TrainingPlanEntity entity) {
        if (entity.getExercises() != null) {
            for (Exercise exercise : entity.getExercises()) {
                exercise.setTrainingPlanEntity(entity);
            }
        }
    }
}
