package app.caueferreira.oneapptocatchthemall.data.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */

public class PokemonEntity {

    private int id, baseExperience, height, order, weight;
    private String name;
    private List<AbilityEntity> abilities;
    private List<FormEntity> forms;
    private List<GameIndexEntity> gameIndices;
    private List<ItemEntity> heldItems;
    private List<StatsEntity.LocationAreaEncountersEntity> locationAreaEncounterses;
    private List<MoveEntity> moves;
    private SpeciesEntity species;
    private SpritesEntity sprites;
    private List<StatsEntity> stats;
    private List<TypeEntity> types;

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

    public List<AbilityEntity> getAbilities() {
        return abilities;
    }

    public List<FormEntity> getForms() {
        return forms;
    }

    public List<GameIndexEntity> getGameIndices() {
        return gameIndices;
    }

    public List<ItemEntity> getHeldItems() {
        return heldItems;
    }

    public List<StatsEntity.LocationAreaEncountersEntity> getLocationAreaEncounterses() {
        return locationAreaEncounterses;
    }

    public List<MoveEntity> getMoves() {
        return moves;
    }

    public SpeciesEntity getSpecies() {
        return species;
    }

    public SpritesEntity getSpripes() {
        return sprites;
    }

    public List<StatsEntity> getStats() {
        return stats;
    }

    public List<TypeEntity> getTypes() {
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
