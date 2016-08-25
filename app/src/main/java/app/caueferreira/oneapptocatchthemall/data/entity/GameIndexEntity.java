package app.caueferreira.oneapptocatchthemall.data.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class GameIndexEntity {


    private String gameIndex;
    private VersionEntity version;

    public String getGameIndex() {
        return gameIndex;
    }

    public VersionEntity getVersion() {
        return version;
    }

    public GameIndexEntity(String gameIndex, VersionEntity version) {
        this.gameIndex = gameIndex;
        this.version = version;
    }
}
