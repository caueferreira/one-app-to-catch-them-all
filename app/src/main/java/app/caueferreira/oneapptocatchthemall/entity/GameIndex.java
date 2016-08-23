package app.caueferreira.oneapptocatchthemall.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class GameIndex {


    private String gameIndex;
    private Version version;

    public String getGameIndex() {
        return gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    public GameIndex(String gameIndex, Version version) {
        this.gameIndex = gameIndex;
        this.version = version;
    }
}
