package app.caueferreira.oneapptocatchthemall.domain.entity;

/**
 * Created by caueferreira on 8/25/16.
 */

public class Type {

    private String name;

    public static Type create() {
        return new Type();
    }

    public Type withName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Type{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
