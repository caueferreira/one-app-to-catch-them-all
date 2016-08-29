package app.caueferreira.oneapptocatchthemall.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.caueferreira.oneapptocatchthemall.presentation.AndroidApplication;
import app.caueferreira.oneapptocatchthemall.presentation.internal.component.ApplicationComponent;

/**
 * Created by caueferreira on 8/29/16.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }
}
