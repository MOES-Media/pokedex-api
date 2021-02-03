package be.moesmedia.pokedex.api.entities;

import javax.persistence.*;

import be.moesmedia.pokedex.api.clients.dto.GenerationResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon_generations")
@Data
public class PokemonGeneration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_generations_id_seq")
    @SequenceGenerator(name = "pokemon_generations_id_seq", sequenceName = "pokemon_generations_id_seq", allocationSize = 3)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "generation")
    private List<SinglePokemon> pokemons = new ArrayList<>();


    public static PokemonGeneration fromGenerationResponse(GenerationResponse response) {
        final var generation = new PokemonGeneration();
        generation.setLocation(response.getMainRegion().getName());
        generation.setName(response.getName());
        return null;
    }

    public SinglePokemon addPokemonToGeneration(SinglePokemon pokemon){
        pokemon.setGeneration(this);
        pokemons.add(pokemon);
        return pokemon;
    }

}
