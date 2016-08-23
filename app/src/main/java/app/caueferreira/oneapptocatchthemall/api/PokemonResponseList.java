package app.caueferreira.oneapptocatchthemall.api;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */

public class PokemonResponseList {

    private int count;
    private String previous, next;
    private List<PokemonResponse> results;

    public int getCount() {
        return count;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNext() {
        return next;
    }

    public List<PokemonResponse> getResults() {
        return results;
    }
}
