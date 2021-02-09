package be.moesmedia.pokedex.api.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NamedResource {

    private String name;
    @JsonProperty(value = "url")
    private String location;

}
