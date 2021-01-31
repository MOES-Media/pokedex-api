package be.moesmedia.pokedex.api.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.moesmedia.pokedex.api.clients.dto.GenerationsResponse;
import be.moesmedia.pokedex.api.clients.dto.PokemonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PokedexRestClient {

    private final RestTemplate pokedexRestTemplate;

    public void getGenerations() {
        final var generation = pokedexRestTemplate.getForObject("/generation", GenerationsResponse.class);
        log.info(generation.toString());
    }

    public void getSinglePokemon(int pokemonNumber) {
        var pokemon = pokedexRestTemplate.getForObject("/pokemon/{pokemonNumber}", PokemonResponse.class, pokemonNumber);
        log.info(pokemon.toString());
    }
}
