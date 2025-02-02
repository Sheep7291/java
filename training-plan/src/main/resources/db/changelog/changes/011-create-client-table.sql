CREATE TABLE IF NOT EXISTS clients (
id SERIAL PRIMARY KEY,
username VARCHAR(255),
trainer_id INT REFERENCES trainers(id)
);