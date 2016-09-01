package app.caueferreira.oneapptocatchthemall.presentation.model.request;

/**
 * Created by caue.ferreira on 9/1/16.
 */

public class PokemonListRequest {

    private int offset, limit;

    public static PokemonListRequest create() {
        return new PokemonListRequest();
    }

    public PokemonListRequest withOffset(final int offset) {
        this.offset = offset;
        return this;
    }

    public PokemonListRequest withLimit(final int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PokemonListRequest{");
        sb.append("offset=").append(offset);
        sb.append(", limit=").append(limit);
        sb.append('}');
        return sb.toString();
    }
}
