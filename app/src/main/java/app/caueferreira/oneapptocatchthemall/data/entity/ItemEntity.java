package app.caueferreira.oneapptocatchthemall.data.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class ItemEntity {

    private ItemDetailEntity item;
    private VersionDetailsEntity versionDetails;

    private class ItemDetailEntity {

        private String name, url;
    }

    private class VersionDetailsEntity {

        private int rarity;
        private VersionEntity version;
    }
}
