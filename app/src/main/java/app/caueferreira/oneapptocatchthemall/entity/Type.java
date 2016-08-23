package app.caueferreira.oneapptocatchthemall.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class Type {

    private int slot;
    private TypeDetail type;

    public class TypeDetail {

        private String name, url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TypeDetail{");
            sb.append("name='").append(name).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public int getSlot() {
        return slot;
    }

    public TypeDetail getType() {
        return type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Type{");
        sb.append("slot=").append(slot);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
