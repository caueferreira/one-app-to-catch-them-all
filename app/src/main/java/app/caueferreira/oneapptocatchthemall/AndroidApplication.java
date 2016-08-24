package app.caueferreira.oneapptocatchthemall;

import android.app.Application;

/**
 * Created by caueferreira on 8/24/16.
 */

public class AndroidApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    public void initializeInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }
}
