package be.moesmedia.pokedex.api.clients.dto;

import lombok.Data;

@Data
public class PokemonMoveResponse {

    private Move move;

    @Data
    static class Move {
        private String move;
    }

}
