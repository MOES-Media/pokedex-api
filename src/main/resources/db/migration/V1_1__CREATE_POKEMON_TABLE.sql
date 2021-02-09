CREATE SEQUENCE pokemon_id_seq START 1 INCREMENT 3;
CREATE SEQUENCE pokemon_types_id_seq START 1 INCREMENT 3;
CREATE SEQUENCE pokemon_abilities_id_seq START 1 INCREMENT 3;
CREATE SEQUENCE pokemon_moves_id_seq START 1 INCREMENT 3;

CREATE TABLE pokemon (
    id BIGINT PRIMARY KEY,
    generation_id BIGINT NOT NULL,
    name VARCHAR(255),
    weight DECIMAL,
    height DECIMAL,
    sprite VARCHAR(255)

);
CREATE TABLE pokemon_types(
    id BIGINT PRIMARY KEY,
    type VARCHAR(255)
);
CREATE TABLE pokemon_pokemon_types(
    pokemon_id BIGINT NOT NULL,
    pokemon_type_id BIGINT NOT NULL,
    PRIMARY KEY (pokemon_id, pokemon_type_id)
);
CREATE TABLE pokemon_abilities(
    id BIGINT PRIMARY KEY,
    ability VARCHAR(255)
);
CREATE TABLE pokemon_pokemon_abilities(
    pokemon_id BIGINT NOT NULL,
    pokemon_ability_id BIGINT NOT NULL,
    PRIMARY KEY (pokemon_id, pokemon_ability_id)
);
CREATE TABLE pokemon_moves(
    id BIGINT PRIMARY KEY,
    move VARCHAR(255)
);
CREATE TABLE pokemon_pokemon_moves(
    pokemon_id BIGINT NOT NULL,
    pokemon_move_id BIGINT NOT NULL,
    PRIMARY KEY (pokemon_id, pokemon_move_id)
);
ALTER TABLE pokemon
ADD CONSTRAINT fk_pokemon_pokemon_generations FOREIGN KEY (generation_id) REFERENCES pokemon_generations(id);
ALTER TABLE pokemon_pokemon_types
ADD CONSTRAINT fk_pokemon_pokemon_types_pokemon_types FOREIGN KEY (pokemon_type_id) REFERENCES pokemon_types(id);
ALTER TABLE pokemon_pokemon_types
ADD CONSTRAINT fk_pokemon_pokemon_types_pokemon FOREIGN KEY (pokemon_id) REFERENCES pokemon(id);