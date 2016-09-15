package app.caueferreira.oneapptocatchthemall.presentation.model.response;

/**
 * Created by caueferreira on 8/29/16.
 */

public class TypeResponse {

    private String name;

    public static TypeResponse create() {
        return new TypeResponse();
    }

    public TypeResponse withName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TypeResponse{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}