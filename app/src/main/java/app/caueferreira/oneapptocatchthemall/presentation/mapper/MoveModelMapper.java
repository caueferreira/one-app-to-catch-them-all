package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Move;
import app.caueferreira.oneapptocatchthemall.presentation.model.MoveModel;

/**
 * Created by caueferreira on 8/29/16.
 */

@Singleton
public class MoveModelMapper {

    @Inject
    public MoveModelMapper() {
    }

    public MoveModel transform(final Move move) {

        return MoveModel.create()
                .withName(move.getName());
    }

    public List<MoveModel> transform(final List<Move> moveList){
        List<MoveModel> moveModelList = new ArrayList<>();

        for(Move move : moveList)
            moveModelList.add(transform(move));

        return moveModelList;
    }
}