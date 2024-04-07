ALTER TABLE Exercise
ADD CONSTRAINT exercisent_trainingplan_id
FOREIGN KEY(trainingPlanEntityId) REFERENCES trainingplan(id)