CREATE TYPE institution_type AS ENUM ('UNIVERSITY', 'COLLEGE');
ALTER TABLE institutions ADD COLUMN type institution_type;

ALTER TABLE institutions ADD COLUMN parent_id INT;
ALTER TABLE institutions ADD FOREIGN KEY (parent_id) REFERENCES institutions(id);