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

    public GenerationsResponse getGenerations() {
        final var result = pokedexRestTemplate.getForObject("/generation", GenerationsResponse.class);
        log.info(result.toString());
        return result;
    }

    public void getSinglePokemon(int pokemonNumber) {
        var pokemon = pokedexRestTemplate.getForObject("/pokemon/{pokemonNumber}", PokemonResponse.class, pokemonNumber);
        log.info(pokemon.toString());
    }

    public <T> T getNamedResource(String namedResourceLocation, Class<T> responseType) {
        log.info(namedResourceLocation);
        return pokedexRestTemplate.getForObject(namedResourceLocation, responseType);
    }

}
