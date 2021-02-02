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
