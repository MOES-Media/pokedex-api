package be.moesmedia.pokedex.api.entities;

import lombok.Data;

import javax.persistence.*;

import be.moesmedia.pokedex.api.clients.dto.PokemonMoveResponse;

import java.util.List;

@Entity
@Table(name = "pokemon_moves")
@Data
public class PokemonMove {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_moves_id_seq")
    @SequenceGenerator(name = "pokemon_moves_id_seq", sequenceName = "pokemon_moves_id_seq", allocationSize = 3)
    private Long id;

    @Column(name = "move")
    private String name;

    @ManyToMany(mappedBy = "moves")
    List<SinglePokemon> pokemons;
    
    public static PokemonMove fromPokemonMoveResponse (PokemonMoveResponse response){
        final var move = new PokemonMove();
        move.setName(response.getMove().getMove());
        
         return move;
    
    }
}
