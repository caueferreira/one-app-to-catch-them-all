package app.caueferreira.oneapptocatchthemall.presentation.model.response;

/**
 * Created by caueferreira on 8/29/16.
 */

public class StatsResponse {

    private String name;
    private String value;

    public static StatsResponse create() {
        return new StatsResponse();
    }

    public StatsResponse withName(final String name) {
        this.name = name;
        return this;
    }

    public StatsResponse withValue(final String value) {
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
        final StringBuilder sb = new StringBuilder("StatsResponse{");
        sb.append("name='").append(name).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}