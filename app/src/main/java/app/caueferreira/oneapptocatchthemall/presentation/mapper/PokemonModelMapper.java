package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.MoveResponse;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.PokemonResponse;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.StatsResponse;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.TypeResponse;

/**
 * Created by caueferreira on 8/29/16.
 */


@Singleton
public class PokemonModelMapper {

    private MoveModelMapper moveModelMapper;
    private StatsModelMapper statsModelMapper;
    private TypeModelMapper typeModelMapper;


    @Inject
    public PokemonModelMapper() {
        moveModelMapper = new MoveModelMapper();
        statsModelMapper = new StatsModelMapper();
        typeModelMapper = new TypeModelMapper();
    }

    public PokemonResponse transform(final Pokemon pokemon) {
        List<MoveResponse> moveList;
        List<StatsResponse> statsList;
        List<TypeResponse> typeList;

        moveList = moveModelMapper.transform(pokemon.getMoves());
        statsList = statsModelMapper.transform(pokemon.getStats());
        typeList = typeModelMapper.transform(pokemon.getTypes());

        return PokemonResponse.create()
                .withName(pokemon.getName())
                .withNumber(String.valueOf(pokemon.getNumber()))
                .withSprite(pokemon.getSprite())
                .withMoves(moveList)
                .withStats(statsList)
                .withTypes(typeList);
    }
}