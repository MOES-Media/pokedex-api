package be.moesmedia.pokedex.api.entities;

import be.moesmedia.pokedex.api.clients.dto.PokemonResponse;
import lombok.Data;

import javax.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @JoinTable(name = "pokemon_pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_type_id"))
    List<PokemonType> types;

    @ManyToMany
    @JoinTable(name = "pokemon_pokemon_abilities", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_ability_id"))
    private List<PokemonAbility> abilities;

    @ManyToMany
    @JoinTable(name = "pokemon_pokemon_moves", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_move_id"))
    private List<PokemonMove> moves;

    /*
     * @OneToMany
     * 
     * @Column(name = "sprites") private String sprite;
     */

    public static SinglePokemon fromPokemonResponse(PokemonResponse response) {
        final var pokemon = new SinglePokemon();

        pokemon.setName(response.getName());
        pokemon.setHeight(response.getHeight());
        pokemon.setWeight(response.getWeight());

        pokemon.setAbilities(response.getAbilities().stream()
                .map(abilityResponse -> PokemonAbility.fromPokemonAbilityResponse(abilityResponse))
                .collect(Collectors.toList()));

        pokemon.setTypes(
                response.getTypes().stream().map(PokemonType::fromPokemonTypeResponse).collect(Collectors.toList()));

        pokemon.setMoves(
                response.getMoves().stream().map(PokemonMove::fromPokemonMoveResponse).collect(Collectors.toList()));

        return pokemon;
    }

}
