package be.moesmedia.pokedex.api.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PokedexRestClientConfiguration {
    
    @Bean
    public RestTemplateBuilder pokedexRestTemplateBuilder() {
        return new RestTemplateBuilder().rootUri("https://pokeapi.co/api/v2/");
    }

    @Bean
    public RestTemplate pokedexRestTemplate(final RestTemplateBuilder pokedexRestTemplateBuilder){
        return pokedexRestTemplateBuilder.build();
    }

}
