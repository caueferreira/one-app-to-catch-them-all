package app.caueferreira.oneapptocatchthemall.presentation.model.response;

/**
 * Created by caueferreira on 8/29/16.
 */

public class MoveResponse {

    private String name;

    public static MoveResponse create() {
        return new MoveResponse();
    }

    public MoveResponse withName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoveResponse{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
