package app.caueferreira.oneapptocatchthemall.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class Ability {

    private boolean isHidden;
    private int slot;
    private AbilityDetail ability;


    private class AbilityDetail {

        private String name, url;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }

    public AbilityDetail getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ability{");
        sb.append("isHidden=").append(isHidden);
        sb.append(", slot=").append(slot);
        sb.append(", ability=").append(ability);
        sb.append('}');
        return sb.toString();
    }
}
