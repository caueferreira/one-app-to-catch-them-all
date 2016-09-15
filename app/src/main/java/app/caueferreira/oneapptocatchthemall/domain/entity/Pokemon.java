package app.caueferreira.oneapptocatchthemall.domain.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/25/16.
 */

public class Pokemon {

    private int number;
    private String name, sprite;

    private List<Move> moveList;
    private List<Stats> statsList;
    private List<Type> typeList;

    public static Pokemon create() {
        return new Pokemon();
    }

    public Pokemon withName(final String name) {
        this.name = name;
        return this;
    }

    public Pokemon withNumber(final int number) {
        this.number = number;
        return this;
    }

    public Pokemon withSprite(final String sprite) {
        this.sprite = sprite;
        return this;
    }

    public Pokemon withMoves(final List<Move> moveList) {
        this.moveList = moveList;
        return this;
    }


    public Pokemon withStats(final List<Stats> statsList) {
        this.statsList = statsList;
        return this;
    }

    public Pokemon withTypes(final List<Type> typeList) {
        this.typeList = typeList;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    public List<Move> getMoves() {
        return moveList;
    }

    public List<Stats> getStats() {
        return statsList;
    }

    public List<Type> getTypes() {
        return typeList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokemon{");
        sb.append("number=").append(number);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sprite='").append(sprite).append('\'');
        sb.append(", moveList=").append(moveList);
        sb.append(", statsList=").append(statsList);
        sb.append(", typeList=").append(typeList);
        sb.append('}');
        return sb.toString();
    }
}
