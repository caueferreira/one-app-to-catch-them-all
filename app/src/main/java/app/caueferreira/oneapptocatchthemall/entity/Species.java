package app.caueferreira.oneapptocatchthemall.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class Species {

    private String name, url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Species{");
        sb.append("name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
