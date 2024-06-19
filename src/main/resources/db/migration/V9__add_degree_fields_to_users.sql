ALTER TABLE users ADD COLUMN highest_degree_id INTEGER;
ALTER TABLE users ADD FOREIGN KEY (highest_degree_id) REFERENCES degrees(id);

ALTER TABLE users ADD COLUMN pursuing_degree_id INTEGER;
ALTER TABLE users ADD FOREIGN KEY (pursuing_degree_id) REFERENCES degrees(id);