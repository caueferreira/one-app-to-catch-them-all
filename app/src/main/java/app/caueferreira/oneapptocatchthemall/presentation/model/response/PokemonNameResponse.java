package app.caueferreira.oneapptocatchthemall.presentation.model.response;

/**
 * Created by caue.ferreira on 9/1/16.
 */

public class PokemonNameResponse {

    private String name;

    public static PokemonNameResponse create() {
        return new PokemonNameResponse();
    }

    public PokemonNameResponse withName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PokemonNameResponse{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
