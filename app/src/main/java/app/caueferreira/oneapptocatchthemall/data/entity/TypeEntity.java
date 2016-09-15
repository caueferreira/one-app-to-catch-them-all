package app.caueferreira.oneapptocatchthemall.data.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class TypeEntity {

    private int slot;
    private TypeDetailEntity type;

    public class TypeDetailEntity {

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

    public TypeDetailEntity getType() {
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
