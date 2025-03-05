package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.ExerciseDto;
import learning.trainingPlan.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {


    @Mapping(target = "trainingPlanEntityId", source = "trainingPlanEntity.id")
    ExerciseDto exerciseToExerciseDTO(Exercise exercise);

    @Mapping(target = "trainingPlanEntity.id", source = "trainingPlanEntityId")
    Exercise exerciseDTOToExercise(ExerciseDto exerciseDTO);

    List<ExerciseDto> fromExerciseListToExerciseDTOList(List<Exercise> exerciseList);

    List<Exercise> fromExerciseDTOListToExercise(List<ExerciseDto> trainingPlanDTOList);
}
