package be.moesmedia.pokedex.api.clients.dto;
import lombok.Data;


@Data
public class PokemonResponse {

    private String name; //name of pokemon
    private double weight; //weight of pokemon
    private double height; // height of pokemon
    private PokemonTypeResponse[] types; //pokemon types

    private PokemonAbilityResponse[] abilities; //passive abilities
    private PokemonMoveResponse[] moves; //attacks
    private double pokedexNumber; //pokedex number

    private String spriteLocation;
    //ASK HOW TO GET SPRITES
    //https://pokeapi.co/api/v2/pokemon/1
}