package be.moesmedia.pokedex.api.entities;

import be.moesmedia.pokedex.api.clients.dto.PokemonResponse;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
@Data
public class SinglePokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_id_seq")
    @SequenceGenerator(name = "pokemon_id_seq", sequenceName = "pokemon_id_seq", allocationSize = 3)
    private Long id;

    @Column
    private String name;
    @Column
    private double weight;
    @Column
    private double height;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private PokemonGeneration generation;

    // @Column
    // private PokemonType[] types;

    public static SinglePokemon fromPokemonResponse(PokemonResponse response) {
        final var pokemon = new SinglePokemon();
        pokemon.setName(response.getName());
        pokemon.setHeight(response.getHeight());
        pokemon.setWeight(response.getWeight());

        return pokemon;
    }

}
