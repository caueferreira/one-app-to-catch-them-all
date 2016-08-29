package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Stats;
import app.caueferreira.oneapptocatchthemall.presentation.model.StatsModel;

/**
 * Created by caueferreira on 8/29/16.
 */

@Singleton
public class StatsModelMapper {

    @Inject
    public StatsModelMapper() {
    }

    public StatsModel transform(final Stats stats) {

        return StatsModel.create()
                .withName(stats.getName())
                .withValue(String.valueOf(stats.getValue()));
    }

    public List<StatsModel> transform(final List<Stats> statsList){
        List<StatsModel> statsModelList = new ArrayList<>();

        for(Stats stats : statsList)
            statsModelList.add(transform(stats));

        return statsModelList;
    }
}
