package be.moesmedia.pokedex.api.entities;


import be.moesmedia.pokedex.api.clients.dto.PokemonResponse;
import be.moesmedia.pokedex.api.clients.dto.PokemonTypeResponse;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Set;

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
    Set<SinglePokemon> pokemon;

}
