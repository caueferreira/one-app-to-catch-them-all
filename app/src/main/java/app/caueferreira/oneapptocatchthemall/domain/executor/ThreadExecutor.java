package app.caueferreira.oneapptocatchthemall.domain.executor;

import rx.Scheduler;

/**
 * Created by caueferreira on 9/8/16.
 */

public class ThreadExecutor {

    private Scheduler scheduler;

    public ThreadExecutor(final Scheduler scheduler){
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }
}
