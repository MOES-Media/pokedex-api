CREATE SEQUENCE pokemon_generations_id_seq START 1 INCREMENT 3;

CREATE TABLE pokemon_generations (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);