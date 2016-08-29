package app.caueferreira.oneapptocatchthemall.presentation.model;

/**
 * Created by caueferreira on 8/29/16.
 */

public class TypeModel {

    private String name;

    public static TypeModel create() {
        return new TypeModel();
    }

    public TypeModel withName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TypeModel{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}