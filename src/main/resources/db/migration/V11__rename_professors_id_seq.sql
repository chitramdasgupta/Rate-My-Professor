ALTER SEQUENCE professors_id_seq RENAME TO users_id_seq;
ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('users_id_seq');