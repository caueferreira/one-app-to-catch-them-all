package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Stats;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.StatsResponse;

/**
 * Created by caueferreira on 8/29/16.
 */

@Singleton
public class StatsModelMapper {

    @Inject
    public StatsModelMapper() {
    }

    public StatsResponse transform(final Stats stats) {

        return StatsResponse.create()
                .withName(stats.getName())
                .withValue(String.valueOf(stats.getValue()));
    }

    public List<StatsResponse> transform(final List<Stats> statsList){
        List<StatsResponse> statsResponseList = new ArrayList<>();

        for(Stats stats : statsList)
            statsResponseList.add(transform(stats));

        return statsResponseList;
    }
}
