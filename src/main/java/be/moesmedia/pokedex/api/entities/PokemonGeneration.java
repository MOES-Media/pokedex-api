package be.moesmedia.pokedex.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import be.moesmedia.pokedex.api.clients.dto.GenerationResponse;
import lombok.Data;

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

    public static PokemonGeneration fromGenerationResponse(GenerationResponse response) {
        final var generation = new PokemonGeneration();
        generation.setLocation(response.getMainRegion().getName());
        generation.setName(response.getName());
        return null;
    }

}
