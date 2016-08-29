package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.presentation.model.MoveModel;
import app.caueferreira.oneapptocatchthemall.presentation.model.PokemonModel;
import app.caueferreira.oneapptocatchthemall.presentation.model.StatsModel;
import app.caueferreira.oneapptocatchthemall.presentation.model.TypeModel;

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

    public PokemonModel transform(final Pokemon pokemon) {
        List<MoveModel> moveList;
        List<StatsModel> statsList;
        List<TypeModel> typeList;

        moveList = moveModelMapper.transform(pokemon.getMoves());
        statsList = statsModelMapper.transform(pokemon.getStats());
        typeList = typeModelMapper.transform(pokemon.getTypes());

        return PokemonModel.create()
                .withName(pokemon.getName())
                .withNumber(String.valueOf(pokemon.getNumber()))
                .withSprite(pokemon.getSprite())
                .withMoves(moveList)
                .withStats(statsList)
                .withTypes(typeList);
    }
}