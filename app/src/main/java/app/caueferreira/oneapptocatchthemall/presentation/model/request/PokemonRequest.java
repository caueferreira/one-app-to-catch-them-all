package app.caueferreira.oneapptocatchthemall.presentation.model.request;

/**
 * Created by caue.ferreira on 9/1/16.
 */

public class PokemonRequest {

    private int number;

    public static PokemonRequest create() {
        return new PokemonRequest();
    }

    public PokemonRequest withNumber(final int number) {
        this.number = number;
        return this;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PokemonRequest{");
        sb.append("number=").append(number);
        sb.append('}');
        return sb.toString();
    }
}
