package be.moesmedia.pokedex.api.clients.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationResponse {
    
    @JsonProperty("main_region")
    private MainRegion mainRegion;

    private String name;

    @JsonProperty("pokemon_species")
    private List<NamedResource> pokemons;

    @Data
    public static class MainRegion {
        private String name;
    }
}
