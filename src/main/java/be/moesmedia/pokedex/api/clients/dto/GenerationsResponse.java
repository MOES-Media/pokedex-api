package be.moesmedia.pokedex.api.clients.dto;

import java.util.List;

import lombok.Data;

@Data
public class GenerationsResponse {
    
    private List<NamedResource> results;

}
