package be.moesmedia.pokedex.api.clients.dto;

import lombok.Data;

@Data
public class PokemonType {

    private Type type;

    @Data
    static class Type {
        private String name;
    }
}

/**
 * 
 * { "slot": 1, "type": { "name": "grass", "url":
 * "https://pokeapi.co/api/v2/type/12/" } },
 * 
 */