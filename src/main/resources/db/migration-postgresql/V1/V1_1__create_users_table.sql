CREATE SEQUENCE sequence_users START 1;

CREATE TABLE users (
    user_id INTEGER CONSTRAINT users_pk PRIMARY KEY,
    email VARCHAR(30),
    username VARCHAR(15),
    password TEXT,
    enabled BOOLEAN
);

ALTER SEQUENCE sequence_users OWNED BY users.user_id;

CREATE TABLE user_roles (
    user_id INTEGER,
    role VARCHAR(15),
    PRIMARY KEY (user_id, role),
    CONSTRAINT user_roles_fk FOREIGN KEY(user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);