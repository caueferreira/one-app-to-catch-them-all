package app.caueferreira.oneapptocatchthemall.entity;

import java.util.List;

/**
 * Created by caueferreira on 8/18/16.
 */
public class Stats {

    private int baseStat, effort;
    private StatsDetail stat;

    public class StatsDetail {

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
    public static class LocationAreaEncounters {

        private LocationArea locationArea;
        private VersionDetails versionDetails;

        private class LocationArea {

            private String name, url;
        }

        private class VersionDetails {

            private int maxChance;
            private List<EncounterDetail> encounterDetails;
            private Version version;


            private class EncounterDetail {

                private int minLevel, maxLevel, chance;
                private List<ConditionValue> conditionValues;
                private Method method;

                private class ConditionValue {

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

                private class Method {

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

                public List<ConditionValue> getConditionValues() {
                    return conditionValues;
                }

                public Method getMethod() {
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

        public LocationArea getLocationArea() {
            return locationArea;
        }

        public VersionDetails getVersionDetails() {
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

    public StatsDetail getStat() {
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
