CREATE TABLE conference
(
    id                 SERIAL PRIMARY KEY,
    title              TEXT UNIQUE NOT NULL,
    description        TEXT NOT NULL,
    type_id            INTEGER REFERENCES type (id) ON DELETE CASCADE NOT NULL,
    organization_title TEXT NOT NULL,
    location_id        INTEGER REFERENCES location (id) ON DELETE CASCADE NOT NULL,
    start_datetime     TEXT NOT NULL,
    end_datetime       TEXT NOT NULL
);