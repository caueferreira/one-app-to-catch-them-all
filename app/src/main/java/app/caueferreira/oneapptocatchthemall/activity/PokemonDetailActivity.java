package app.caueferreira.oneapptocatchthemall.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.caueferreira.oneapptocatchthemall.AndroidApplication;
import app.caueferreira.oneapptocatchthemall.ApplicationComponent;
import app.caueferreira.oneapptocatchthemall.R;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }
}