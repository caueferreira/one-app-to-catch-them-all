package app.caueferreira.oneapptocatchthemall.presentation;

import android.app.Application;

import app.caueferreira.oneapptocatchthemall.presentation.internal.component.ApplicationComponent;
import app.caueferreira.oneapptocatchthemall.presentation.internal.component.DaggerApplicationComponent;
import app.caueferreira.oneapptocatchthemall.presentation.internal.module.ApplicationModule;

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

    private void initializeInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }
}
