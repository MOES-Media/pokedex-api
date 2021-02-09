package be.moesmedia.pokedex.api.clients.dto;

import lombok.Data;

@Data
public class PokemonAbilityResponse {

    private Ability ability;

    @Data
    public static class Ability {
        private String name;
    }

}
