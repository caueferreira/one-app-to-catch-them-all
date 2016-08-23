package app.caueferreira.oneapptocatchthemall.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */
public class Move {

    private MoveDetail move;
    private List<VersionGroupDetail> versionGroupDetails;

    public class MoveDetail {

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

    private class VersionGroupDetail {

        private int levelLearnedAt;
        private VersionGroup versionGroup;
        private MoveLearnMethod moveLearnMethod;

        private class VersionGroup {

            private String name, url;
        }

        private class MoveLearnMethod {

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

        public VersionGroup getVersionGroup() {
            return versionGroup;
        }

        public MoveLearnMethod getMoveLearnMethod() {
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

    public MoveDetail getMove() {
        return move;
    }

    public List<VersionGroupDetail> getVersionGroupDetails() {
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
