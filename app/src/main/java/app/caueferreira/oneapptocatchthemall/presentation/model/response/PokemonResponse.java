package app.caueferreira.oneapptocatchthemall.presentation.model.response;

import java.util.List;

/**
 * Created by caueferreira on 8/29/16.
 */

public class PokemonResponse {
    private String number;
    private String name, sprite;
    private List<MoveResponse> moveList;
    private List<StatsResponse> statsList;
    private List<TypeResponse> typeList;

    public static PokemonResponse create() {
        return new PokemonResponse();
    }

    public PokemonResponse withName(final String name) {
        this.name = name;
        return this;
    }

    public PokemonResponse withNumber(final String number) {
        this.number = number;
        return this;
    }

    public PokemonResponse withSprite(final String sprite) {
        this.sprite = sprite;
        return this;
    }

    public PokemonResponse withMoves(final List<MoveResponse> moveList) {
        this.moveList = moveList;
        return this;
    }


    public PokemonResponse withStats(final List<StatsResponse> statsList) {
        this.statsList = statsList;
        return this;
    }

    public PokemonResponse withTypes(final List<TypeResponse> typeList) {
        this.typeList = typeList;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    public List<MoveResponse> getMoves() {
        return moveList;
    }

    public List<StatsResponse> getStats() {
        return statsList;
    }

    public List<TypeResponse> getTypes() {
        return typeList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PokemonResponse{");
        sb.append("number='").append(number).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", sprite='").append(sprite).append('\'');
        sb.append(", moveList=").append(moveList);
        sb.append(", statsList=").append(statsList);
        sb.append(", typeList=").append(typeList);
        sb.append('}');
        return sb.toString();
    }
}
