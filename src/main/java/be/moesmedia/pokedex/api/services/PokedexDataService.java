package be.moesmedia.pokedex.api.services;

import java.util.stream.Collectors;

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
public class PokedexDataService {

    private final PokedexRestClient pokedexRestClient;

    private final PokemonGenerationsRepository pokemonGenerationsRepository;

    public void populateGenerationsTable() {
        log.debug("fetching generations overview");
        final var generationsOverview = pokedexRestClient.getGenerations();
        final var results = generationsOverview.getResults().stream().map(namedResource -> {
            log.debug("fetching generation detail");
            return pokedexRestClient.getNamedResource(
                    namedResource.getGenerationDetailLocation().replace(PokedexRestClientConfiguration.BASE_URL, ""),
                    GenerationResponse.class);
        }).map(generationResponse -> {
            final var generation = new PokemonGeneration();
            generation.setLocation(generationResponse.getMainRegion().getName());
            generation.setName(generationResponse.getName());

            log.debug("writing generation to database");
            return pokemonGenerationsRepository.save(generation);
        }).collect(Collectors.toList());
        log.info(results.toString());
    }

}
