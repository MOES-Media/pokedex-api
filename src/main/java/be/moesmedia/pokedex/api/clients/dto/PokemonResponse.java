package be.moesmedia.pokedex.api.clients.dto;
import lombok.Data;


@Data
public class PokemonResponse {

    private String name;
    private double weight;
    private double height;

    private PokemonType types[];

}