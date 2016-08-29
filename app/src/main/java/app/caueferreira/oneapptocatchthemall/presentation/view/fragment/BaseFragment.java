package app.caueferreira.oneapptocatchthemall.presentation.view.fragment;

import android.app.Fragment;

import app.caueferreira.oneapptocatchthemall.presentation.internal.component.ApplicationComponent;
import app.caueferreira.oneapptocatchthemall.presentation.view.activity.BaseActivity;

/**
 * Created by caueferreira on 8/29/16.
 */

public class BaseFragment extends Fragment {

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseActivity)getActivity()).getApplicationComponent();
    }
}
