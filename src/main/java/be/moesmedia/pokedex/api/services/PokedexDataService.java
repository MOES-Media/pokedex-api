package be.moesmedia.pokedex.api.services;

import be.moesmedia.pokedex.api.clients.dto.PokemonResponse;
import be.moesmedia.pokedex.api.entities.SinglePokemon;
import be.moesmedia.pokedex.api.repositories.SinglePokemonRepository;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import be.moesmedia.pokedex.api.clients.PokedexRestClient;
import be.moesmedia.pokedex.api.clients.dto.GenerationResponse;
import be.moesmedia.pokedex.api.clients.dto.NamedResource;
import be.moesmedia.pokedex.api.configuration.PokedexRestClientConfiguration;
import be.moesmedia.pokedex.api.entities.PokemonGeneration;
import be.moesmedia.pokedex.api.repositories.PokemonGenerationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokedexDataService {

    private final PokedexRestClient pokedexRestClient;

    private final PokemonGenerationsRepository pokemonGenerationsRepository;
    private final SinglePokemonRepository singlePokemonRepository;

    private final Function<NamedResource, String> extractResourceLocation = namedResource -> namedResource.getLocation()
            .replace(PokedexRestClientConfiguration.BASE_URL, "");

    /**
     * TODO in other files 1. create pokemon entity 2. create pokemon repository
     */
    public void populateGenerationsTable() {

        log.info("fetching generations overview");
        final var generationsOverview = pokedexRestClient.getGenerations();

        generationsOverview.getResults().stream().map(namedResource -> {
            log.info("fetching generation detail");
            final var generation = pokedexRestClient.getNamedResource(
                    namedResource.getLocation().replace(PokedexRestClientConfiguration.BASE_URL, ""),
                    GenerationResponse.class);
            return generation;
        }).forEach(generationResponse -> {

            // pokemone-species heeft een varieties property waar de default variety
            // uitgehaald moet worden, daar zit de locatie van de pokemon met moves,
            // abilities, types,... in

            /**
             * "varieties": [ { "is_default": true, "pokemon": { "name": "bulbasaur", "url": "https://pokeapi.co/api/v2/pokemon/1/" } } ]
             */

            log.info("writing generation to database");
            final var pokemonGeneration = pokemonGenerationsRepository
                    .save(PokemonGeneration.fromGenerationResponse(generationResponse));
            generationResponse
                    .getPokemons().stream().map(extractResourceLocation).map(resourceLocation -> pokedexRestClient
                            .getNamedResource(resourceLocation, PokemonResponse.class))
                    .map(SinglePokemon::fromPokemonResponse).map(pokemon -> {
                        pokemon.setGeneration(pokemonGeneration);
                        return pokemon;
                    }).forEach(singlePokemonRepository::save);
        });
    }
}