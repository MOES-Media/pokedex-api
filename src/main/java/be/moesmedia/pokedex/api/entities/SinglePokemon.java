package be.moesmedia.pokedex.api.entities;

import be.moesmedia.pokedex.api.clients.dto.PokemonAbilityResponse;
import be.moesmedia.pokedex.api.clients.dto.PokemonMoveResponse;
import be.moesmedia.pokedex.api.clients.dto.PokemonResponse;
import be.moesmedia.pokedex.api.clients.dto.PokemonTypeResponse;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<PokemonType> types;

    @ManyToMany
    @Column (name = "abilities")
    private PokemonAbilityResponse[] abilities;

    @ManyToMany
    @Column (name ="move")
    private PokemonMoveResponse[] moves;


    @Column(name = "sprites")
    private String sprite;

    public static SinglePokemon fromPokemonResponse(PokemonResponse response) {
        final var pokemon = new SinglePokemon();
        pokemon.setName(response.getName());
        pokemon.setHeight(response.getHeight());
        pokemon.setWeight(response.getWeight());
        pokemon.setTypes(response.getTypes());
        pokemon.setAbilities(response.getAbilities());
        pokemon.setMoves(response.getMoves());

        return pokemon;
    }

}
