package app.caueferreira.oneapptocatchthemall.data.mapper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.entity.PokemonEntity;
import app.caueferreira.oneapptocatchthemall.domain.entity.Move;
import app.caueferreira.oneapptocatchthemall.domain.entity.Pokemon;
import app.caueferreira.oneapptocatchthemall.domain.entity.Stats;
import app.caueferreira.oneapptocatchthemall.domain.entity.Type;

/**
 * Created by caueferreira on 8/25/16.
 */

@Singleton
public class PokemonEntityMapper {

    private MoveEntityMapper moveEntityMapper;
    private StatsEntityMapper statsEntityMapper;
    private TypeEntityMapper typeEntityMapper;

    @Inject
    public PokemonEntityMapper() {
        moveEntityMapper = new MoveEntityMapper();
        statsEntityMapper = new StatsEntityMapper();
        typeEntityMapper = new TypeEntityMapper();
    }

    public Pokemon transform(final PokemonEntity pokemonEntity) {
        List<Move> moveList;
        List<Stats> statsList;
        List<Type> typeList;

        moveList = moveEntityMapper.transform(pokemonEntity.getMoves());
        statsList = statsEntityMapper.transform(pokemonEntity.getStats());
        typeList = typeEntityMapper.transform(pokemonEntity.getTypes());

        return Pokemon.create()
                .withName(pokemonEntity.getName())
                .withNumber(pokemonEntity.getId())
                .withSprite(pokemonEntity.getSpripes().getFrontDefault())
                .withMoves(moveList)
                .withStats(statsList)
                .withTypes(typeList);
    }
}