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
        return pokedexRestTemplate.getForObject("/generation", GenerationsResponse.class);
    }

    public void getSinglePokemon(int pokemonNumber) {
        var pokemon = pokedexRestTemplate.getForObject("/pokemon/{pokemonNumber}", PokemonResponse.class,
                pokemonNumber);
        log.info(pokemon.toString());
    }

    public <T> T getNamedResource(String namedResourceLocation, Class<T> responseType) {
        log.info("fetching named resource at:" + namedResourceLocation);
        final var result = pokedexRestTemplate.getForObject(namedResourceLocation, responseType);
        return result;
    }

}
