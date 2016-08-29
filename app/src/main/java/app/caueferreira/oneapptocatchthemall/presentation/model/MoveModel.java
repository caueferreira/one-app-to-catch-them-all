package app.caueferreira.oneapptocatchthemall.presentation.model;

/**
 * Created by caueferreira on 8/29/16.
 */

public class MoveModel {

    private String name;

    public static MoveModel create() {
        return new MoveModel();
    }

    public MoveModel withName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoveModel{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
