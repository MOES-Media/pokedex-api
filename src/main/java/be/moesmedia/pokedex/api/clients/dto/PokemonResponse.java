package be.moesmedia.pokedex.api.clients.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PokemonResponse {

    private String name; //name of pokemon
    private double weight; //weight of pokemon
    private double height; // height of pokemon
    private List<PokemonTypeResponse> types = new ArrayList<>(); //pokemon types

    private List<PokemonAbilityResponse> abilities = new ArrayList<>(); //passive abilities
    private List<PokemonMoveResponse> moves = new ArrayList<>(); //attacks
    private double pokedexNumber; //pokedex number

    //private String spriteLocation;
    //ASK HOW TO GET SPRITES
    //https://pokeapi.co/api/v2/pokemon/1
}