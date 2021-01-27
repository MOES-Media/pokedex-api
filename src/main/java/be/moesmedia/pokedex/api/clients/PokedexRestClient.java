package be.moesmedia.pokedex.api.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PokedexRestClient {
    
    private final RestTemplate pokedexRestTemplate;

    public void getPokedexes() {
        final var pokedex = pokedexRestTemplate.getForObject("/pokedex", String.class);
        log.info(pokedex);
    }

    public void getSinglePokemon(int pokemonNumber){
    
        var pokemon = pokedexRestTemplate.getForObject("/pokemon/{pokemonNumber}", String.class, pokemonNumber);
        //log.info(pokemon);
    }
}
