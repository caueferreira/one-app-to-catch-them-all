package app.caueferreira.oneapptocatchthemall.data.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */
public class MoveEntity {

    private MoveDetailEntity move;
    private List<VersionGroupDetailEntity> versionGroupDetails;

    public class MoveDetailEntity {

        private String name, url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MoveDetail{");
            sb.append("name='").append(name).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    private class VersionGroupDetailEntity {

        private int levelLearnedAt;
        private VersionGroupEntity versionGroup;
        private MoveLearnMethodEntity moveLearnMethod;

        private class VersionGroupEntity {

            private String name, url;
        }

        private class MoveLearnMethodEntity {

            private String name, url;

            public String getName() {
                return name;
            }

            public String getUrl() {
                return url;
            }

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("MoveLearnMethod{");
                sb.append("name='").append(name).append('\'');
                sb.append(", url='").append(url).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public int getLevelLearnedAt() {
            return levelLearnedAt;
        }

        public VersionGroupEntity getVersionGroup() {
            return versionGroup;
        }

        public MoveLearnMethodEntity getMoveLearnMethod() {
            return moveLearnMethod;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("VersionGroupDetails{");
            sb.append("levelLearnedAt=").append(levelLearnedAt);
            sb.append(", versionGroup=").append(versionGroup);
            sb.append(", moveLearnMethod=").append(moveLearnMethod);
            sb.append('}');
            return sb.toString();
        }
    }

    public MoveDetailEntity getMove() {
        return move;
    }

    public List<VersionGroupDetailEntity> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Move{");
        sb.append("move=").append(move);
        sb.append(", versionGroupDetails=").append(versionGroupDetails);
        sb.append('}');
        return sb.toString();
    }
}
