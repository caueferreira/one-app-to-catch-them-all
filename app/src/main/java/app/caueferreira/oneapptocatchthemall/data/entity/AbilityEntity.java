package app.caueferreira.oneapptocatchthemall.data.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class AbilityEntity {

    private boolean isHidden;
    private int slot;
    private AbilityDetailEntity ability;


    private class AbilityDetailEntity {

        private String name, url;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }

    public AbilityDetailEntity getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbilityEntity{");
        sb.append("isHidden=").append(isHidden);
        sb.append(", slot=").append(slot);
        sb.append(", ability=").append(ability);
        sb.append('}');
        return sb.toString();
    }
}
