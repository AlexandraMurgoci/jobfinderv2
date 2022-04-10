CREATE SEQUENCE sequence_jobs START 1;

CREATE TABLE jobs (
    job_id INTEGER CONSTRAINT jobs_pk PRIMARY KEY,
    title VARCHAR(100),
    company VARCHAR(100),
    level VARCHAR(100),
    type VARCHAR(100),
    city VARCHAR(100),
    requirements TEXT,
    description TEXT
);

ALTER SEQUENCE sequence_jobs OWNED BY jobs.job_id;