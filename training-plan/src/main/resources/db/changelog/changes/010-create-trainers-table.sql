CREATE TABLE IF NOT EXISTS trainers (
id SERIAL PRIMARY KEY,
username VARCHAR(255),
account_start_date DATE,
account_end_date DATE
);