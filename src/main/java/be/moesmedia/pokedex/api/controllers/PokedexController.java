package be.moesmedia.pokedex.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.moesmedia.pokedex.api.clients.PokedexRestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/pokedex")
@RequiredArgsConstructor
@Slf4j
public class PokedexController {

    private final PokedexRestClient pokedexRestClient;

    @GetMapping
    @RequestMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public void getPokedexes() {
        pokedexRestClient.getPokedexes();
    }
    @GetMapping
    @RequestMapping(value = "/pokemon/{pokemonNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void getPokemon(@PathVariable("pokemonNumber") int pokemonNumber){
        log.info("pokemon number: " + pokemonNumber);
        pokedexRestClient.getSinglePokemon(pokemonNumber);
    }
}
