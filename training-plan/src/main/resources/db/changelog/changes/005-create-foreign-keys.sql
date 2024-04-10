ALTER TABLE Exercise
ADD CONSTRAINT exercisent_trainingplan_id
FOREIGN KEY(training_plan_entity_id) REFERENCES trainingplan(id)