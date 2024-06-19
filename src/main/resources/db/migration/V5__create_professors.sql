CREATE TABLE professors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    institution_id INTEGER REFERENCES institutions(id),
    department_id INTEGER REFERENCES departments(id)
);