package app.caueferreira.oneapptocatchthemall.presentation.model;

/**
 * Created by caueferreira on 8/29/16.
 */

public class StatsModel {

    private String name;
    private String value;

    public static StatsModel create() {
        return new StatsModel();
    }

    public StatsModel withName(final String name) {
        this.name = name;
        return this;
    }

    public StatsModel withValue(final String value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatsModel{");
        sb.append("name='").append(name).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}