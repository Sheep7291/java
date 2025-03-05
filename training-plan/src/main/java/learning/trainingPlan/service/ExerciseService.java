package learning.trainingPlan.service;

import learning.trainingPlan.dto.ExerciseDto;
import learning.trainingPlan.entity.Exercise;
import learning.trainingPlan.entity.TrainingPlanEntity;
import learning.trainingPlan.exception.ExerciseNotFoundException;
import learning.trainingPlan.mapper.ExerciseMapper;
import learning.trainingPlan.repository.ExerciseRepository;
import learning.trainingPlan.repository.TrainingPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ExerciseService {
    final private ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;
    private final TrainingPlanRepository trainingPlanRepository;

    public void createExercise(ExerciseDto exerciseDTO, Long trainingPlanId) {
        exerciseDTO.setTrainingPlanEntityId(trainingPlanId);
        exerciseRepository.save(exerciseMapper.exerciseDTOToExercise(exerciseDTO));
    }

    public void deleteExercise(Long id) {
        exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with ID: " + id));
        exerciseRepository.deleteById(id);
    }

    public void addExerciseToTrainingPlan(ExerciseDto exerciseDTO, String username, LocalDate trainingDate) {
        TrainingPlanEntity trainingPlanEntity = trainingPlanRepository.findByCreatedByAndTrainingDate(username, trainingDate);
        exerciseDTO.setAddedBy(username);
        Exercise exercise = exerciseMapper.exerciseDTOToExercise(exerciseDTO);
        exercise.setTrainingPlanEntity(trainingPlanEntity);
        exerciseRepository.save(exercise);
    }
}
