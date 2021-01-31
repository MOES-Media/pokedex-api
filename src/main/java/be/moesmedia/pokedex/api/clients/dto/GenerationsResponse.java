package be.moesmedia.pokedex.api.clients.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationsResponse {
    
    private List<Generation> results;

    @Data
    static class Generation {
        private String name;
        @JsonProperty(value = "url")
        private String generationDetailLocation;
    }

}
