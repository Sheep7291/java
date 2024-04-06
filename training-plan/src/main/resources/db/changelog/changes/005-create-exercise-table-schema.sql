CREATE TABLE Exercise(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
trainingPlanEntityId INTEGER NOT NULL,
nameOfExcercise VARCHAR(255),
rangeOfReps VARCHAR(255),
sets INTEGER,
breakBetweenSets VARCHAR(255),
urlToExercise VARCHAR(255)
);