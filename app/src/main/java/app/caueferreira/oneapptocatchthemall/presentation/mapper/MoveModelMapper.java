package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Move;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.MoveResponse;

/**
 * Created by caueferreira on 8/29/16.
 */

@Singleton
public class MoveModelMapper {

    @Inject
    public MoveModelMapper() {
    }

    public MoveResponse transform(final Move move) {

        return MoveResponse.create()
                .withName(move.getName());
    }

    public List<MoveResponse> transform(final List<Move> moveList){
        List<MoveResponse> moveResponseList = new ArrayList<>();

        for(Move move : moveList)
            moveResponseList.add(transform(move));

        return moveResponseList;
    }
}