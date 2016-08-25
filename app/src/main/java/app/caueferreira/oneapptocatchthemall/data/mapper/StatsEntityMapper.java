package app.caueferreira.oneapptocatchthemall.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.entity.StatsEntity;
import app.caueferreira.oneapptocatchthemall.domain.entity.Stats;

/**
 * Created by caueferreira on 8/25/16.
 */

@Singleton
public class StatsEntityMapper {

    @Inject
    public StatsEntityMapper() {
    }

    public Stats transform(final StatsEntity statsEntity) {

        return Stats.create()
                .withName(statsEntity.getStat().getName())
                .withValue(statsEntity.getBaseStat());
    }

    public List<Stats> transform(final List<StatsEntity> statsEntities){
        List<Stats> statsList = new ArrayList<>();

        for(StatsEntity statsEntity : statsEntities)
            statsList.add(transform(statsEntity));

        return statsList;
    }
}
