CREATE TABLE conference_user
(
    id            SERIAL PRIMARY KEY,
    user_id       INTEGER UNIQUE REFERENCES "user" (id) ON DELETE CASCADE,
    conference_id TEXT NOT NULL
);