package be.moesmedia.pokedex.api.entities;

import lombok.Data;

import java.util.List;

import javax.persistence.*;

import be.moesmedia.pokedex.api.clients.dto.PokemonAbilityResponse;

@Entity
@Table(name = "pokemon_abilities")
@Data
public class PokemonAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_abilities_id_seq")
    @SequenceGenerator(name = "pokemon_abilities_id_seq", sequenceName = "pokemon_abilities_id_seq", allocationSize = 3)
    private Long id;

    @Column (name = "ability")
    private String name;

    @ManyToMany(mappedBy = "abilities")
    private List<SinglePokemon> pokemons;

    public static PokemonAbility fromPokemonAbilityResponse(PokemonAbilityResponse response) {
        final var ability = new PokemonAbility();
        ability.setName(response.getAbility().getName());

        return ability;
    }
}
