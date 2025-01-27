package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.ExerciseDTO;
import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.Exercise;
import learning.trainingPlan.entity.TrainingPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<ExerciseDTO> fromExerciseListToExerciseDTOList(List<Exercise> exerciseList);

    ExerciseDTO exerciseToExerciseDTO(Exercise exercise);

    List<Exercise> fromExerciseDTOListToExercise(List<ExerciseDTO> trainingPlanDTOList);
    @Mapping(target = "trainingPlanEntity", ignore = true)
    Exercise exerciseDTOToExercise(ExerciseDTO exerciseDTO);
}
