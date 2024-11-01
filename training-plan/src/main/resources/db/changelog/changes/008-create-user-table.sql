CREATE TABLE IF NOT EXISTS training_plan_user (
id SERIAL PRIMARY KEY,
username VARCHAR(255),
password VARCHAR(255),
roles VARCHAR(255)
);