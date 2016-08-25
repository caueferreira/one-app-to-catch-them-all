package app.caueferreira.oneapptocatchthemall.data.entity;

/**
 * Created by caueferreira on 8/18/16.
 */
public class SpritesEntity {

    private String backFemale, backShinyFemale, backDefault, frontFemale, frontShinyFemale, backShiny, frontDefault, frontShiny;

    public String getBackFemale() {
        return backFemale;
    }

    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public String getFrontFemale() {
        return frontFemale;
    }

    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sprites{");
        sb.append("backFemale='").append(backFemale).append('\'');
        sb.append(", backShinyFemale='").append(backShinyFemale).append('\'');
        sb.append(", backDefault='").append(backDefault).append('\'');
        sb.append(", frontFemale='").append(frontFemale).append('\'');
        sb.append(", frontShinyFemale='").append(frontShinyFemale).append('\'');
        sb.append(", backShiny='").append(backShiny).append('\'');
        sb.append(", frontDefault='").append(frontDefault).append('\'');
        sb.append(", frontShiny='").append(frontShiny).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
