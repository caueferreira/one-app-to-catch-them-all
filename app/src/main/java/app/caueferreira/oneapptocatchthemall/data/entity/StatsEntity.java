package app.caueferreira.oneapptocatchthemall.data.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */
public class StatsEntity {

    private int baseStat, effort;
    private StatsDetailEntity stat;

    public class StatsDetailEntity {

        private String name, url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("StatsDetail{");
            sb.append("name='").append(name).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * Created by caueferreira on 8/18/16.
     */
    public static class LocationAreaEncountersEntity {

        private LocationAreaEntity locationArea;
        private VersionDetailsEntity versionDetails;

        private class LocationAreaEntity {

            private String name, url;
        }

        private class VersionDetailsEntity {

            private int maxChance;
            private List<EncounterDetailEntity> encounterDetails;
            private VersionEntity version;


            private class EncounterDetailEntity {

                private int minLevel, maxLevel, chance;
                private List<ConditionValueEntity> conditionValues;
                private MethodEntity method;

                private class ConditionValueEntity {

                    private String name, url;

                    public String getName() {
                        return name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    @Override
                    public String toString() {
                        final StringBuilder sb = new StringBuilder("ConditionValue{");
                        sb.append("name='").append(name).append('\'');
                        sb.append(", url='").append(url).append('\'');
                        sb.append('}');
                        return sb.toString();
                    }
                }

                private class MethodEntity {

                    private String name, url;

                    public String getName() {
                        return name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    @Override
                    public String toString() {
                        final StringBuilder sb = new StringBuilder("Method{");
                        sb.append("name='").append(name).append('\'');
                        sb.append(", url='").append(url).append('\'');
                        sb.append('}');
                        return sb.toString();
                    }
                }

                public int getMinLevel() {
                    return minLevel;
                }

                public int getMaxLevel() {
                    return maxLevel;
                }

                public int getChance() {
                    return chance;
                }

                public List<ConditionValueEntity> getConditionValues() {
                    return conditionValues;
                }

                public MethodEntity getMethod() {
                    return method;
                }

                @Override
                public String toString() {
                    final StringBuilder sb = new StringBuilder("EncounterDetail{");
                    sb.append("minLevel=").append(minLevel);
                    sb.append(", maxLevel=").append(maxLevel);
                    sb.append(", chance=").append(chance);
                    sb.append(", conditionValues=").append(conditionValues);
                    sb.append(", method=").append(method);
                    sb.append('}');
                    return sb.toString();
                }
            }
        }

        public LocationAreaEntity getLocationArea() {
            return locationArea;
        }

        public VersionDetailsEntity getVersionDetails() {
            return versionDetails;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("LocationAreaEncounters{");
            sb.append("locationArea=").append(locationArea);
            sb.append(", versionDetails=").append(versionDetails);
            sb.append('}');
            return sb.toString();
        }
    }

    public int getBaseStat() {
        return baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public StatsDetailEntity getStat() {
        return stat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stats{");
        sb.append("baseStat=").append(baseStat);
        sb.append(", effort=").append(effort);
        sb.append(", stat=").append(stat);
        sb.append('}');
        return sb.toString();
    }
}
