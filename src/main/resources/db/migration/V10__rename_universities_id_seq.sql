ALTER SEQUENCE universities_id_seq RENAME TO institutions_id_seq;
ALTER TABLE institutions ALTER COLUMN id SET DEFAULT nextval('institutions_id_seq');