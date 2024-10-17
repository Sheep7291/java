CREATE TABLE Exercise(
id SERIAL PRIMARY KEY,
training_plan_entity_id INTEGER NOT NULL,
name_of_exercise VARCHAR(255),
range_of_reps VARCHAR(255),
sets INTEGER,
break_between_sets VARCHAR(255),
url_to_exercise VARCHAR(255)
);