package be.moesmedia.pokedex.api.services;

import org.springframework.stereotype.Service;

import be.moesmedia.pokedex.api.clients.PokedexRestClient;
import be.moesmedia.pokedex.api.clients.dto.GenerationResponse;
import be.moesmedia.pokedex.api.configuration.PokedexRestClientConfiguration;
import be.moesmedia.pokedex.api.entities.PokemonGeneration;
import be.moesmedia.pokedex.api.repositories.PokemonGenerationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokdexDataService {

    private final PokedexRestClient pokedexRestClient;

    private final PokemonGenerationsRepository pokemonGenerationsRepository;

    /**
     * TODO in other files 1. create pokemon entity 2. create pokemon repository
     */
    public void populateGenerationsTable() {
        log.debug("fetching generations overview");
        final var generationsOverview = pokedexRestClient.getGenerations();
        generationsOverview.getResults().stream().map(namedResource -> {
            log.debug("fetching generation detail");
            return pokedexRestClient.getNamedResource(
                    namedResource.getGenerationDetailLocation().replace(PokedexRestClientConfiguration.BASE_URL, ""),
                    GenerationResponse.class);
        }).forEach(generationResponse -> {
            log.debug("writing generation to database");
            pokemonGenerationsRepository.save(PokemonGeneration.fromGenerationResponse(generationResponse));
            // get pokemon detail with restclient (generation
            // response heeft pokemon details)

            // transform pokemonResponse naar pokemon entity

            // save pokemon entity
        });

    }

}
