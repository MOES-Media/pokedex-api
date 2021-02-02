package be.moesmedia.pokedex.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.moesmedia.pokedex.api.entities.PokemonGeneration;

@Repository
public interface PokemonGenerationsRepository extends JpaRepository<PokemonGeneration, Long>{   
}
