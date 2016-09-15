package app.caueferreira.oneapptocatchthemall.domain.entity;

/**
 * Created by caueferreira on 8/25/16.
 */

public class Stats {

    private String name;
    private int value;

    public static Stats create() {
        return new Stats();
    }

    public Stats withName(final String name) {
        this.name = name;
        return this;
    }

    public Stats withValue(final int value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stats{");
        sb.append("name='").append(name).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}