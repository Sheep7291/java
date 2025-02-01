package learning.trainingPlan.service;

import learning.trainingPlan.dto.ExerciseDTO;
import learning.trainingPlan.mapper.ExerciseMapper;
import learning.trainingPlan.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExerciseService {
    final private ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public void createExercise(ExerciseDTO exerciseDTO) {
        exerciseRepository.save(exerciseMapper.exerciseDTOToExercise(exerciseDTO));
    }
}
