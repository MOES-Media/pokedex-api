package be.moesmedia.pokedex.api.entities;

import lombok.Data;

import javax.persistence.*;

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
}
