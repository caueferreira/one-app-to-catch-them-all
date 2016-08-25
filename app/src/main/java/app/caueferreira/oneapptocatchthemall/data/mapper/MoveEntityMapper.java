package app.caueferreira.oneapptocatchthemall.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.entity.MoveEntity;
import app.caueferreira.oneapptocatchthemall.domain.entity.Move;

/**
 * Created by caueferreira on 8/25/16.
 */

@Singleton
public class MoveEntityMapper {

    @Inject
    public MoveEntityMapper() {
    }

    public Move transform(final MoveEntity moveEntity) {

        return Move.create()
                .withName(moveEntity.getMove().getName());
    }

    public List<Move> transform(final List<MoveEntity> moveEntityList){
        List<Move> moveList = new ArrayList<>();

        for(MoveEntity moveEntity : moveEntityList)
            moveList.add(transform(moveEntity));

        return moveList;
    }
}
