package learning.trainingPlan.mapper;

import learning.trainingPlan.dto.TrainingPlanDTO;
import learning.trainingPlan.entity.TrainingPlanEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface TrainingPlanMapper {
    List<TrainingPlanDTO> fromTrainingPLanEntityListToTrainingPlanDTOList(List<TrainingPlanEntity> trainingPlanEntityList);

    TrainingPlanDTO TrainingPlanEntityToTrainingPlanDTO(TrainingPlanEntity trainingPlanEntity);
}
