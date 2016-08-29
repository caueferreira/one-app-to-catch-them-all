package app.caueferreira.oneapptocatchthemall.presentation.model;

import java.util.List;

/**
 * Created by caueferreira on 8/29/16.
 */

public class PokemonModel {
    private String number;
    private String name, sprite;
    private List<MoveModel> moveList;
    private List<StatsModel> statsList;
    private List<TypeModel> typeList;

    public static PokemonModel create() {
        return new PokemonModel();
    }

    public PokemonModel withName(final String name) {
        this.name = name;
        return this;
    }

    public PokemonModel withNumber(final String number) {
        this.number = number;
        return this;
    }

    public PokemonModel withSprite(final String sprite) {
        this.sprite = sprite;
        return this;
    }

    public PokemonModel withMoves(final List<MoveModel> moveList) {
        this.moveList = moveList;
        return this;
    }


    public PokemonModel withStats(final List<StatsModel> statsList) {
        this.statsList = statsList;
        return this;
    }

    public PokemonModel withTypes(final List<TypeModel> typeList) {
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

    public List<MoveModel> getMoves() {
        return moveList;
    }

    public List<StatsModel> getStats() {
        return statsList;
    }

    public List<TypeModel> getTypes() {
        return typeList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PokemonModel{");
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
