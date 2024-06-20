CREATE TABLE reviews (
  id SERIAL PRIMARY KEY,
  student_id INTEGER NOT NULL,
  professor_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  comment TEXT,
  created_at TIMESTAMP NOT NULL,
  CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES users(id) ON DELETE CASCADE,
  CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES users(id) ON DELETE CASCADE,
  CONSTRAINT chk_rating_range CHECK (rating >= 1 AND rating <= 5),
  -- A student can submit only one review for the same professor
  CONSTRAINT uq_student_professor_review UNIQUE (student_id, professor_id)
);

-- Indexes on the foreign keys for better query performance
CREATE INDEX idx_reviews_student ON reviews(student_id);
CREATE INDEX idx_reviews_professor ON reviews(professor_id);

-- Trigger to automatically set the created_at timestamp
CREATE OR REPLACE FUNCTION set_review_timestamp()
RETURNS TRIGGER AS $$
BEGIN
    NEW.created_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_review_timestamp_trigger
BEFORE INSERT ON reviews
FOR EACH ROW
EXECUTE FUNCTION set_review_timestamp();
