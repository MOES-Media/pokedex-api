package be.moesmedia.pokedex.api.entities;

import lombok.Data;

import javax.persistence.*;

import be.moesmedia.pokedex.api.clients.dto.PokemonTypeResponse;

import java.util.List;

@Entity
@Table(name = "pokemon_types")
@Data
public class PokemonType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_types_id_seq")
    @SequenceGenerator(name = "pokemon_types_id_seq", sequenceName = "pokemon_types_id_seq", allocationSize = 3)
    private Long id;

    @Column(name = "type")
    private String name;

    @ManyToMany(mappedBy = "types")
    List<SinglePokemon> pokemon;

    public static PokemonType fromPokemonTypeResponse(PokemonTypeResponse response){
        final var type = new PokemonType();
        type.setName(response.getType().getName());

        return type;
    }

}
