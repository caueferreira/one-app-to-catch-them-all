package app.caueferreira.oneapptocatchthemall.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */

public class Pokemon {

    private int id, baseExperience, height, order, weight;
    private String name;
    private List<Ability> abilities;
    private List<Form> forms;
    private List<GameIndex> gameIndices;
    private List<Item> heldItems;
    private List<Stats.LocationAreaEncounters> locationAreaEncounterses;
    private List<Move> moves;
    private Species species;
    private Sprites sprites;
    private List<Stats> stats;
    private List<Type> types;

    public int getId() {
        return id;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public int getOrder() {
        return order;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<Form> getForms() {
        return forms;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public List<Item> getHeldItems() {
        return heldItems;
    }

    public List<Stats.LocationAreaEncounters> getLocationAreaEncounterses() {
        return locationAreaEncounterses;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Species getSpecies() {
        return species;
    }

    public Sprites getSpripes() {
        return sprites;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokemon{");
        sb.append("id=").append(id);
        sb.append(", baseExperience=").append(baseExperience);
        sb.append(", height=").append(height);
        sb.append(", order=").append(order);
        sb.append(", weight=").append(weight);
        sb.append(", name='").append(name).append('\'');
        sb.append(", abilities=").append(abilities);
        sb.append(", forms=").append(forms);
        sb.append(", gameIndices=").append(gameIndices);
        sb.append(", heldItems=").append(heldItems);
        sb.append(", locationAreaEncounterses=").append(locationAreaEncounterses);
        sb.append(", moves=").append(moves);
        sb.append(", species=").append(species);
        sb.append(", sprites=").append(sprites);
        sb.append(", stats=").append(stats);
        sb.append(", types=").append(types);
        sb.append('}');
        return sb.toString();
    }
}
