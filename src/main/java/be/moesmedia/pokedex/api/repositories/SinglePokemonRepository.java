package be.moesmedia.pokedex.api.repositories;

import be.moesmedia.pokedex.api.entities.SinglePokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SinglePokemonRepository extends JpaRepository<SinglePokemon, Long> {
}
