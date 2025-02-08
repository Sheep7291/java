package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.ExerciseDTO;
import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.Exercise;
import learning.trainingPlan.entity.TrainingPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {


    @Mapping(target = "trainingPlanEntityId", source = "trainingPlanEntity.id")
    ExerciseDTO exerciseToExerciseDTO(Exercise exercise);

    @Mapping(target = "trainingPlanEntity.id" , source = "trainingPlanEntityId", ignore = true)
    Exercise exerciseDTOToExercise(ExerciseDTO exerciseDTO);

    List<ExerciseDTO> fromExerciseListToExerciseDTOList(List<Exercise> exerciseList);

    List<Exercise> fromExerciseDTOListToExercise(List<ExerciseDTO> trainingPlanDTOList);
}
