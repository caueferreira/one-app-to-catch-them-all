package app.caueferreira.oneapptocatchthemall.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class Item {

    private ItemDetail item;
    private VersionDetails versionDetails;

    private class ItemDetail {

        private String name, url;
    }

    private class VersionDetails {

        private int rarity;
        private Version version;
    }
}
