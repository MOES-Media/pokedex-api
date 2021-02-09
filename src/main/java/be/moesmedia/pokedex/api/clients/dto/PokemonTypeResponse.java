package be.moesmedia.pokedex.api.clients.dto;

import lombok.Data;

@Data
public class PokemonTypeResponse {


    private Type type;

    @Data
    static class Type {
        private String name;
    }
}
